package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Etiqueta;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControladorInicio {

    private ServicioPublicacion servicioPublicacion;

    @Autowired
    public ControladorInicio(ServicioPublicacion sercioPublicacion){
        this.servicioPublicacion = sercioPublicacion;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView irAHome(HttpServletRequest request) {
        ModelMap model = new ModelMap();

        Usuario user;
        if(request.getSession().getAttribute("USUARIO") != null){
            user = (Usuario) request.getSession().getAttribute("USUARIO");
            List<Publicacion> recomendaciones = servicioPublicacion.recomendarPublicaciones(user);
            if(recomendaciones != null)
            model.put("recomendaciones", recomendaciones);

            List<Publicacion> publicaciones = servicioPublicacion.listarPubliacion(user);
            model.put("publicaciones", publicaciones);
        }
        else{
            List<Publicacion> publicaciones = servicioPublicacion.listarPubliacionGenerico();
            model.put("publicaciones", publicaciones);
        }

        return new ModelAndView("home", model);
    }

}
