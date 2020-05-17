package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.servicios.ServicioBuscarLibro;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.io.IOException;
import java.util.List;


@Controller
public class MiControlador {

    private ServicioBuscarLibro servicioBuscarLibro;

    @Autowired
    public MiControlador(ServicioBuscarLibro servicioBuscarLibro){
        this.servicioBuscarLibro = servicioBuscarLibro;
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

    @RequestMapping(path = "/buscar", method = RequestMethod.GET)
    public ModelAndView buscarLibro(@RequestParam("nombre") String nombre) throws IOException {
        List<Libro> results = servicioBuscarLibro.buscarLibro(nombre);
        ModelMap model = new ModelMap();
        String titulo = results.get(0).getNombre();
        model.put("nombre", titulo);
        model.put("buscado", nombre);
        return new ModelAndView("resultadoBusqueda", model);
    }


}
