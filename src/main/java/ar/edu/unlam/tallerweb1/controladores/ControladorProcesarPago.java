package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioPagar;
import com.mercadopago.exceptions.MPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorProcesarPago {

    private final ServicioPagar servicioPagar;

    @Autowired
    public ControladorProcesarPago(ServicioPagar servicioPagar) {
        this.servicioPagar = servicioPagar;
    }

    @RequestMapping(path = "/procesar_pago/{libro_id}", method = RequestMethod.POST)
    public ModelAndView procesarPago(
            @RequestParam("token") String token,
            @RequestParam("transaction_amount") Float precio,
            @RequestParam("payment_method_id") String metodoDePago,
            @RequestParam("installments") Integer cuotas,
            @RequestParam("email") String mail,
            @RequestParam("description") String descripcion,
            @PathVariable("libro_id") Long libro_id

    ) throws MPException {
        String estadoDePago = servicioPagar.pagarLibro(token, precio, metodoDePago, cuotas, mail, descripcion, libro_id);

        ModelMap model = new ModelMap();
        model.put("descripcion", descripcion);
        model.put("estadoDePago", estadoDePago);
        model.put("precio", precio);
        model.put("metodoDePago", metodoDePago);
        return new ModelAndView("confirmacion-pago", model);
    }
}
