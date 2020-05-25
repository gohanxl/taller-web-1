package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLibro;
import ar.edu.unlam.tallerweb1.servicios.ServicioComprar;
import ar.edu.unlam.tallerweb1.servicios.ServicioComprarImp;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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

        Compra compra = new Compra(libro, usuario);
        session().save(compra);

        assertThat(compra.getId()).isNotNull();

    }

}
