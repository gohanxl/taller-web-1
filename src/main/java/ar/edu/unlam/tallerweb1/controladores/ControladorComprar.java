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

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class ControladorComprar {

    private ServicioPublicacion servicioPublicacion;

    @Autowired
    public ControladorComprar(ServicioPublicacion servicioPublicacion) {
        this.servicioPublicacion = servicioPublicacion;
    }

    @RequestMapping(path = "/checkout", method = RequestMethod.GET)
    public ModelAndView comprarLibro(@RequestParam("publicacionId") String id,
                                     @RequestParam(value = "regalo", required = false) Boolean comoRegalo,
                                     @RequestParam(value = "puntosACanjear", required = false) Integer puntosACanjear,
                                     HttpServletRequest request) throws IOException {

        if(request.getSession().getAttribute("USUARIO") != null){
            ModelMap model = new ModelMap();
            Publicacion publicacion = servicioPublicacion.buscarPublicacionPorId(Long.parseLong(id));
            model.put("publicacion", publicacion);
            model.put("regalo", comoRegalo);
            model.put("puntos", puntosACanjear);
            return new ModelAndView("checkout", model);
        }
        else{
            return new ModelAndView("redirect:/login?next=/checkout?publicacionId="+id);
        }
    }
}
