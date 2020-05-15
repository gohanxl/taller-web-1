package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioComprar;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorComprar {

    private ServicioComprar servicioComprar;

    @Autowired
    public ControladorComprar(ServicioComprar servicioComprar) {
        this.servicioComprar = servicioComprar;
    }

    @RequestMapping(path = "/checkout", method = RequestMethod.GET)
    public ModelAndView comprarLibro(String compra) {

        ModelMap model = new ModelMap();

        model.put("compra", compra);

        return new ModelAndView("checkout", model);
    }
}
