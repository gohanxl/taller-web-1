package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ServicioEnviarEmailTest extends SpringTest {

    private ServicioPublicacion servicioPublicacion = mock(ServicioPublicacion.class);
    private JavaMailSender mailSender = mock(JavaMailSender.class);
    private ServicioEmailImp servicioEmail = spy(new ServicioEmailImp(mailSender, servicioPublicacion));

    private Usuario usuario = new Usuario();
    private Publicacion publicacion = new Publicacion();
    private Libro libro = new Libro();
    private MimeMessage mimeMessage;

    @Before
    public void config(){
        usuario.setId((long) 1);
        usuario.setNombre("Isaias");
        usuario.setEmail("isaias.caporusso@gmail.com");

        libro.setId((long) 1);
        libro.setNombre("Harry Potter");

        publicacion.setId((long) 1);
        publicacion.setPrecio(2500.00);
        publicacion.setFecha(new Date());
        publicacion.setPropietario(usuario);
        publicacion.setLibro(libro);

        mimeMessage = new MimeMessage((Session)null);
    }

    @Test
    public void tetQueVerificaElEnvioCorrectoDeEmails() throws IOException, MessagingException {
        ArgumentCaptor<String> emailCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> textoCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> asuntoCaptor = ArgumentCaptor.forClass(String.class);

        when(servicioPublicacion.buscarPublicacionPorId(publicacion.getId())).thenReturn(publicacion);
        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);
        servicioEmail.emailSimple(publicacion.getId(), usuario);
        verify(servicioEmail, times(1))
                .enviarEmailSimple(emailCaptor.capture(), asuntoCaptor.capture(), textoCaptor.capture());
        assertThat(emailCaptor.getValue()).isEqualTo(usuario.getEmail());
        assertThat(asuntoCaptor.getValue()).isEqualTo("Libro " + publicacion.getLibro().getNombre());
        assertThat(textoCaptor.getValue()).isEqualTo("Libro " + publicacion.getLibro().getNombre());
    }
}
