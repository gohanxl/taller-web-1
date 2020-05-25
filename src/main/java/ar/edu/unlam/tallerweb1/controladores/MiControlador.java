package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MiControlador {

    private ServicioPublicacion servicioPublicacion;

    @Autowired
    public MiControlador(ServicioPublicacion servicioPublicacion){
        this.servicioPublicacion = servicioPublicacion;
    }

    @RequestMapping(path = "/saludar/{nombre}", method = RequestMethod.GET)
    public ModelAndView pepe(@PathVariable String nombre) {

        ModelMap model = new ModelMap();

        model.put("nombre", nombre.toUpperCase());
        return new ModelAndView("saludar");
    }

    @RequestMapping(path = "/test")
    public ModelAndView test(){
        return new ModelAndView("base");
    }

    @RequestMapping(path = "/base", method = RequestMethod.GET)
    public ModelAndView base(){
        return new ModelAndView("base");
    }

}
