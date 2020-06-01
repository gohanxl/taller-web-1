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

public class CompraTest extends SpringTest {

    @Test
    @Transactional
    @Rollback

    public void testRealizarCompra() {

        Usuario usuario = new Usuario();
        session().save(usuario);

        Libro libro = new Libro("pepe", "null", "null");
        session().save(libro);

        Publicacion publicacion = new Publicacion(libro, usuario, 500D);
        session().save(publicacion);

        Compra compra = new Compra(publicacion, usuario);
        session().save(compra);

        assertThat(compra.getId()).isNotNull();

    }

}
