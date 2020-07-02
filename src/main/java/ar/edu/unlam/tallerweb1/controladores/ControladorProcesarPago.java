package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioComprar;
import ar.edu.unlam.tallerweb1.servicios.ServicioPagar;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class ControladorProcesarPago {

    private final ServicioPagar servicioPagar;
    private final ServicioComprar servicioComprar;
    private final ServicioUsuario servicioUsuario;
    private final ServicioPublicacion servicioPublicacion;

    @Autowired
    public ControladorProcesarPago(ServicioPagar servicioPagar, ServicioComprar servicioComprar, ServicioUsuario servicioUsuario, ServicioPublicacion servicioPublicacion) {
        this.servicioPagar = servicioPagar;
        this.servicioComprar = servicioComprar;
        this.servicioUsuario = servicioUsuario;
        this.servicioPublicacion = servicioPublicacion;
    }

    @RequestMapping(path = "/procesar_pago/{publicacionId}", method = RequestMethod.POST)
    public ModelAndView procesarPago(
            @RequestParam("token") String token,
            @RequestParam("transaction_amount") Double precio,
            @RequestParam("payment_method_id") String metodoDePago,
            @RequestParam("installments") Integer cuotas,
            @RequestParam("email") String mail,
            @RequestParam("description") String descripcion,
            @RequestParam(value = "regalo", required = false) String email_regalo,
            @RequestParam(value = "puntosACanjear", required = false) Integer puntosACanjear,
            @PathVariable("publicacionId") Long publicacion_id,
            HttpServletRequest request
    ) throws MPException {
        Usuario comprador = (Usuario) request.getSession().getAttribute("USUARIO");
        Integer puntosRestantes = null;
        String estadoDePago = "bad request";
        String numeroDeTarjeta = null;

        if(email_regalo != null){
            Usuario usuarioRegalo = servicioUsuario.getUsuarioRegalo(email_regalo);
            comprador = usuarioRegalo;
        }

        if(puntosACanjear != null){
            puntosRestantes = servicioPagar.pagarConPuntos(publicacion_id, comprador, precio);
        }

        if(puntosACanjear == null || (puntosACanjear != null && puntosRestantes != null)){
            Payment detallesDePago = servicioPagar.pagarLibro(token, precio, metodoDePago, cuotas, mail, descripcion, publicacion_id, comprador);
            if(detallesDePago.getStatus() != null){
                Payment.Status estado = detallesDePago.getStatus();
                estadoDePago = estado.toString();
                numeroDeTarjeta = detallesDePago.getCard().getLastFourDigits();
            }
        }

        ModelMap model = new ModelMap();
        model.put("descripcion", descripcion);
        model.put("estadoDePago", estadoDePago);
        model.put("precio", precio);
        model.put("puntos", null);
        model.put("metodoDePago", metodoDePago);
        model.put("numeroDeTarjeta", numeroDeTarjeta);
        return new ModelAndView("confirmacion-pago", model);
    }

    @RequestMapping(path = "/canjear-puntos", method = RequestMethod.GET)
    public ModelAndView canjearPuntos(
            @RequestParam("puntosACanjear") Integer puntosACanjear,
            @RequestParam("publicacionId") Long publicacionId,
            HttpServletRequest request
    ) throws IOException {
        Usuario comprador = (Usuario) request.getSession().getAttribute("USUARIO");
        Integer puntosRestantes = servicioPagar.pagarConPuntos(publicacionId, comprador, 0.0);
        String estadoDePago = "bad request";

        if(puntosRestantes != null){
            estadoDePago = "approved";
        }

        Publicacion publicacion = servicioPublicacion.buscarPublicacionPorId(publicacionId);

        ModelMap model = new ModelMap();
        model.put("estadoDePago", estadoDePago);
        model.put("puntos", puntosACanjear);
        model.put("metodoDePago", "Puntos");
        model.put("descripcion", publicacion);
        model.put("precio", null);
        model.put("puntosRestantes", puntosRestantes);
        return new ModelAndView("confirmacion-pago", model);
    }
}
