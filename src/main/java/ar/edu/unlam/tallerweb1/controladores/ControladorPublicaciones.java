package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Compra;
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
public class ControladorPublicaciones {

    private ServicioUsuario servicioUsuario;
    private ServicioPublicacion servicioPublicacion;

    @Autowired
    public ControladorPublicaciones(ServicioUsuario servicioUsuario, ServicioPublicacion servicioPublicacion){
        this.servicioUsuario = servicioUsuario;
        this.servicioPublicacion = servicioPublicacion;
    }

    @RequestMapping(path = "/publicaciones", method = RequestMethod.GET)
    public ModelAndView publicaciones(HttpServletRequest request) {
        Usuario usuario = (Usuario) request.getSession().getAttribute("USUARIO");
        if(usuario != null) {
            List<Publicacion> publicaciones = servicioPublicacion.listarPublicacionDeUsuario(usuario);

            ModelMap model = new ModelMap();
            model.put("publicaciones", publicaciones);
            return new ModelAndView("publicaciones", model);
        }
        else {
            return new ModelAndView("redirect:/");
        }
    }

}
