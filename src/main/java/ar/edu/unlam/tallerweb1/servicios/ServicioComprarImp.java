package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLibro;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;

@Service("servicioComprar")
@Transactional
public class ServicioComprarImp implements ServicioComprar{

    private RepositorioPublicacion servicioPublicacionDao;
    private ServicioEmail servicioEmail;

    @Autowired
    public ServicioComprarImp(RepositorioLibro servicioLibroDao, ServicioEmail servicioEmail){
        this.servicioPublicacionDao = servicioPublicacionDao;
        this.servicioEmail = servicioEmail;
    }

    @Override
    public void comprarLibro(Publicacion publicacion_id, Usuario usuario_id) throws MessagingException {
        Compra compra = new Compra(publicacion_id, usuario_id);
        servicioPublicacionDao.cargarCompra(compra);
        String email = compra.getUsuario().getEmail();
        String asunto = "Compraste " + compra.getPublicacion().getLibro().getNombre();
        String nuevaLinea = System.getProperty("line.separator");
        String texto = "<h3>Resumen de compra</h3>" +
                        nuevaLinea +
                        "Pagaste $" + compra.getPublicacion().getPrecio().toString() +
                        nuevaLinea +
                        "<table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\">" +
                        "  <tr>" +
                        "      <td>" +
                        "          <table cellspacing=\"0\" cellpadding=\"0\">" +
                        "              <tr>" +
                        "                  <td class=”button” bgcolor=\"#ED2939\">" +
                        "                      <a  class=”link” href=\"http://localhost:8080/biblioteca\" target=\"_blank\">\n" +
                        "                          Ver libros" +
                        "                      </a>" +
                        "                  </td>" +
                        "              </tr>" +
                        "          </table>" +
                        "      </td>" +
                        "  </tr>" +
                        "</table>";
        servicioEmail.enviarEmail(email, asunto, texto);
    }
}
