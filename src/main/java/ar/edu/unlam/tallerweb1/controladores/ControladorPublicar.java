package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.servicios.ServicioPublicar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class ControladorPublicar {

    private ServicioPublicar servicioPublicar;

    @Autowired
    public ControladorPublicar(ServicioPublicar servicioPublicar){
        this.servicioPublicar = servicioPublicar;
    }

    @RequestMapping(path = "/publicar", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public ModelAndView publicarLibro(@RequestParam("file") MultipartFile archivo,
                             @RequestParam("nombre") String nombre,
                             @RequestParam("precio") Double precio) throws IOException {
        servicioPublicar.subirArchivo(nombre, precio, archivo);
        ModelMap model = new ModelMap();
        model.put("nombre", nombre);
        model.put("precio", precio);
        model.put("archivo", archivo.getOriginalFilename());
        return new ModelAndView("publicar", model);
    }

    @RequestMapping(path = "/publicar", method = RequestMethod.GET)
    public ModelAndView publicarLibroGet() {

        ModelMap model = new ModelMap();
        return new ModelAndView("publicarForm");
    }


}
