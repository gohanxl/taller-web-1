package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
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

    private ServicioPublicacion sercioPublicacion;

    @Autowired
    public ControladorInicio(ServicioPublicacion sercioPublicacion){
        this.sercioPublicacion = sercioPublicacion;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView irAHome(HttpServletRequest request) {
        List<Publicacion> publicaciones = sercioPublicacion.listarPubliacion();
        ModelMap model = new ModelMap();
        model.put("publicaciones", publicaciones);
        return new ModelAndView("home", model);
    }

}
