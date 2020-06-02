package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.*;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PuntuarTest extends SpringTest {

    @Test
    @Transactional
    @Rollback

    public void testPuntuarPublicacion() {

        Usuario usuario = new Usuario();
        session().save(usuario);

        Libro libro = new Libro("Libro", "null", "null");

        Etiqueta etiqueta = new Etiqueta();
        etiqueta.setDescripcion("Terror");

        List<Etiqueta> etiquetas = new ArrayList<>();
        etiquetas.add(etiqueta);

        Publicacion publicacion = new Publicacion(libro, usuario, 218.00, etiquetas);
        session().save(publicacion);

        Puntaje puntaje = new Puntaje(publicacion, 3, "comentario", usuario);
        session().save(puntaje);

        assertThat(puntaje.getId()).isNotNull();
    }

}
