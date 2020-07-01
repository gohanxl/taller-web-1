package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPagar;
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

@Controller
public class ControladorProcesarPago {

    private final ServicioPagar servicioPagar;
    private final ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorProcesarPago(ServicioPagar servicioPagar, ServicioUsuario servicioUsuario) {
        this.servicioPagar = servicioPagar;
        this.servicioUsuario = servicioUsuario;
    }

    @RequestMapping(path = "/procesar_pago/{publicacion_id}", method = RequestMethod.POST)
    public ModelAndView procesarPago(
            @RequestParam("token") String token,
            @RequestParam("transaction_amount") Double precio,
            @RequestParam("payment_method_id") String metodoDePago,
            @RequestParam("installments") Integer cuotas,
            @RequestParam("email") String mail,
            @RequestParam("description") String descripcion,
            @RequestParam(value = "regalo", required = false) String email_regalo,
//            @RequestParam(value = "precioConEnvio", required = false) Float precioConEnvio,
            @PathVariable("publicacion_id") Long publicacion_id,
            HttpServletRequest request
    ) throws MPException {
        Usuario comprador = (Usuario) request.getSession().getAttribute("USUARIO");
        if(email_regalo != null){
            Usuario usuarioRegalo = servicioUsuario.getUsuarioRegalo(email_regalo);
            comprador = usuarioRegalo;
        }
//        if(precioConEnvio != null){
//            precio = precioConEnvio;
//        }
        Payment detallesDePago = servicioPagar.pagarLibro(token, precio, metodoDePago, cuotas, mail, descripcion, publicacion_id, comprador);

        String estadoDePago = "bad request";
        String numeroDeTarjeta = null;

        if(detallesDePago.getStatus() != null){
            Payment.Status estado = detallesDePago.getStatus();
            estadoDePago = estado.toString();
            numeroDeTarjeta = detallesDePago.getCard().getLastFourDigits();
        }

        ModelMap model = new ModelMap();
        model.put("descripcion", descripcion);
        model.put("estadoDePago", estadoDePago);
        model.put("precio", precio);
        model.put("metodoDePago", metodoDePago);
        model.put("numeroDeTarjeta", numeroDeTarjeta);
        return new ModelAndView("confirmacion-pago", model);
    }
}
