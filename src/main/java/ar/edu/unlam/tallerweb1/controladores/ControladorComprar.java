package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioBuscarLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class ControladorComprar {

    private ServicioBuscarLibro servicioBuscarLibro;

    @Autowired
    public ControladorComprar(ServicioBuscarLibro servicioBuscarLibro) {
        this.servicioBuscarLibro = servicioBuscarLibro;
    }

    @RequestMapping(path = "/checkout", method = RequestMethod.GET)
    public ModelAndView comprarLibro(@RequestParam("publicacionId") String id) throws IOException {

        ModelMap model = new ModelMap();

        Publicacion publicacion = servicioBuscarLibro.buscarLibroPorId(Long.parseLong(id));
        model.put("publicacion", publicacion);

        return new ModelAndView("checkout", model);
    }
}
