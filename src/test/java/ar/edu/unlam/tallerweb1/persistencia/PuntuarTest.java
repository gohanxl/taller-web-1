package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Puntaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

public class PuntuarTest extends SpringTest {

    @Test
    @Transactional
    @Rollback

    public void testPuntuarPublicacion() {

        Usuario usuario = new Usuario();
        session().save(usuario);

        Libro libro = new Libro("Libro", "null", "null");
        Publicacion publicacion = new Publicacion(libro, usuario, 218.00);
        session().save(publicacion);

        Puntaje puntaje = new Puntaje(publicacion, 3, "comentario", usuario);

        assertThat(puntaje.getId()).isNotNull();
    }

}
