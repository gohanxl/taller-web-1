package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class ControladorBiblioteca {

    private ServicioPublicacion servicioPublicacion;
    private ServicioUsuario servicioUsuario;

    @Autowired
    public ControladorBiblioteca(ServicioPublicacion servicioPublicacion, ServicioUsuario servicioUsuario){
        this.servicioPublicacion = servicioPublicacion;
        this.servicioUsuario = servicioUsuario;
    }

    @RequestMapping(path = "/biblioteca", method = RequestMethod.GET)
    public ModelAndView biblioteca(HttpServletRequest request) throws IOException {
        Usuario usuario = (Usuario) request.getSession().getAttribute("USUARIO");
        if(usuario != null) {
            List<Compra> compras = servicioUsuario.getCompras(usuario);

            ModelMap model = new ModelMap();
            model.put("compras", compras);
            return new ModelAndView("biblioteca", model);
        }
        else {
            return new ModelAndView("redirect:/");
        }
    }

}
