package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class ControladorBuscar {

    private ServicioPublicacion servicioPublicacion;

    @Autowired
    public ControladorBuscar(ServicioPublicacion servicioPublicacion){
        this.servicioPublicacion = servicioPublicacion;
    }

    @RequestMapping(path = "/buscar", method = RequestMethod.GET)
    public ModelAndView buscarLibro(@RequestParam("nombre") String nombre) throws IOException {
        List<Publicacion> results = servicioPublicacion.buscarPublicacion(nombre);
        ModelMap model = new ModelMap();
        model.put("buscado", nombre);
        model.put("publicaciones", results);
        return new ModelAndView("home", model);
    }

}
