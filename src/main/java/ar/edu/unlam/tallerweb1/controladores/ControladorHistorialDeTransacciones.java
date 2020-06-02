package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Etiqueta;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class ControladorHistorialDeTransacciones {

    private ServicioUsuario servicioUsuario;
    private ServicioPublicacion servicioPublicacion;

    @Autowired
    public ControladorHistorialDeTransacciones(ServicioUsuario servicioUsuario, ServicioPublicacion servicioPublicacion){
        this.servicioUsuario = servicioUsuario;
        this.servicioPublicacion = servicioPublicacion;
    }

    @RequestMapping(path = "/historial-de-transacciones", method = RequestMethod.GET)
    public ModelAndView historialDeTransacciones(HttpServletRequest request) {
        Usuario usuario = (Usuario) request.getSession().getAttribute("USUARIO");
        if(usuario != null) {
            List<Compra> compras = servicioUsuario.getCompras(usuario);
            List<Publicacion> ventas = servicioUsuario.getVentas(usuario);

            ModelMap model = new ModelMap();
            model.put("compras", compras);
            model.put("ventas", ventas);
            return new ModelAndView("historial-de-transacciones", model);
        }
        else {
            return new ModelAndView("redirect:/");
        }
    }



}
