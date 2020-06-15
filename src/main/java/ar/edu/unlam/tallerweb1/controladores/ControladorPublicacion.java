package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Puntaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPuntaje;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class ControladorPublicacion {

    private ServicioPublicacion servicioPublicacion;
    private ServicioPuntaje servicioPuntaje;
    private ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorPublicacion(ServicioPublicacion servicioPublicacion, ServicioPuntaje servicioPuntaje, ServicioUsuario servicioUsuario) {
        this.servicioPublicacion = servicioPublicacion;
        this.servicioPuntaje = servicioPuntaje;
        this.servicioUsuario = servicioUsuario;
    }

    @RequestMapping(path = "/puntuar", method = RequestMethod.POST)
    public ModelAndView puntuar(@ModelAttribute("puntaje") Puntaje puntaje){
        ModelMap model = new ModelMap();
        puntaje.setFecha(new Date());
        this.servicioPuntaje.puntuarPublicacion(puntaje);
        return new ModelAndView("redirect:/biblioteca");
    }

    @RequestMapping(path = "/publicacion/{publicacion_id}", method = RequestMethod.GET)
    public ModelAndView publicacion(
            @PathVariable("publicacion_id") Long publicacionId,
            HttpServletRequest request) throws IOException {
        Publicacion publicacion = this.servicioPublicacion.buscarPublicacionPorId(publicacionId);
        Double promedio = this.servicioPuntaje.calcularPromedio(publicacion);
        List<Puntaje> puntajes = this.servicioPuntaje.listarPuntaje(publicacion);
        Boolean comprado = this.servicioUsuario.tieneCompra((Long) request.getSession().getAttribute("USUARIO_ID"), publicacionId);
        Boolean puntuado = this.servicioPuntaje.puntuoPublicacion((Long) request.getSession().getAttribute("USUARIO_ID"), publicacionId);
        Puntaje puntaje = new Puntaje();
        ModelMap model = new ModelMap();
        model.put("publicacion", publicacion);
        model.put("puntajes", puntajes);
        model.put("promedio", promedio);
        model.put("puntaje", puntaje);
        model.put("comprado", comprado);
        model.put("puntuado", puntuado);
        return new ModelAndView("publicacion", model);
    }
}
