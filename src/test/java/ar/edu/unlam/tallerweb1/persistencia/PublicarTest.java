package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

public class PublicarTest extends SpringTest {

    @Test
    @Transactional
    @Rollback

    public void testRealizarPublicacion() {

        Usuario usuario = new Usuario();
        session().save(usuario);

        Libro libro = new Libro("Libro", "null", "null");
        Publicacion publicacion = new Publicacion(libro, usuario, 218.00);

        session().save(publicacion);
        assertThat(publicacion.getId()).isNotNull();
        assertThat(libro.getId()).isNotNull();
        assertThat(usuario.getId()).isNotNull();
    }

}
