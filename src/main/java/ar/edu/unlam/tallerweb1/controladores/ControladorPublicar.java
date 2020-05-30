package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Etiqueta;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class ControladorPublicar {

    private ServicioPublicar servicioPublicar;

    @Autowired
    public ControladorPublicar(ServicioPublicar servicioPublicar){
        this.servicioPublicar = servicioPublicar;
    }

    @RequestMapping(path = "/publicar", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public ModelAndView publicarLibro(@RequestParam("archivo") MultipartFile archivo,
                                      @RequestParam("imagen") MultipartFile imagen,
                                      @RequestParam("nombre") String nombre,
                                      @RequestParam("precio") Double precio,
                                      @RequestParam("etiquetas") List<Etiqueta> etiquetas,
                                      HttpServletRequest request) throws IOException {
        Usuario propietario = (Usuario) request.getSession().getAttribute("USUARIO");
        String ruta = request.getSession().getServletContext().getRealPath("/");
        servicioPublicar.subirArchivo(nombre, precio, archivo, imagen, ruta, propietario);
        ModelMap model = new ModelMap();
        model.put("nombre", nombre);
        model.put("precio", precio);
        model.put("etiquetas", etiquetas);
        model.put("archivo", archivo.getOriginalFilename());
        return new ModelAndView("publicar", model);
    }

    @RequestMapping(path = "/publicar", method = RequestMethod.GET)
    public ModelAndView publicarLibroGet() {
        ModelMap model = new ModelMap();
        return new ModelAndView("publicarForm");
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView irAHome(HttpServletRequest request) {
        List<Publicacion> publicaciones = servicioPublicar.listarPubliacion();
        ModelMap model = new ModelMap();
        model.put("publicaciones", publicaciones);
        return new ModelAndView("home", model);
    }
}
