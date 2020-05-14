package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;


@Controller
public class MiControlador {

    @RequestMapping(path = "/saludar/{nombre}", method = RequestMethod.GET)
    public ModelAndView pepe(@PathVariable String nombre) {

        ModelMap model = new ModelMap();

        model.put("nombre", nombre.toUpperCase());
        return new ModelAndView("saludar");
    }

    @RequestMapping(path = "/base", method = RequestMethod.GET)
    public ModelAndView base(){
        return new ModelAndView("base");
    }
}
