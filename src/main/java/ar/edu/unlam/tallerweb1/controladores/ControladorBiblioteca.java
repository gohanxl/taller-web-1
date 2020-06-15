package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Puntaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ControladorBiblioteca {

    private ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorBiblioteca(ServicioUsuario servicioUsuario){
        this.servicioUsuario = servicioUsuario;
    }

    @RequestMapping(path = "/biblioteca", method = RequestMethod.GET)
    public ModelAndView biblioteca(HttpServletRequest request) {
        Usuario usuario = (Usuario) request.getSession().getAttribute("USUARIO");
        if(usuario != null) {
            List<Compra> compras = servicioUsuario.getCompras(usuario);

            List<Puntaje> comprasConPuntaje = servicioUsuario.listarComprasConPuntajePorUsuario(usuario);

            ModelMap model = new ModelMap();
            model.put("comprasConPuntaje", comprasConPuntaje);
            model.put("compras", compras);
            return new ModelAndView("biblioteca", model);
        }
        else {
            return new ModelAndView("redirect:/");
        }
    }

}
