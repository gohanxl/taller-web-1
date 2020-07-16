package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.*;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CompraTest extends SpringTest {

    @Test
    @Transactional
    @Rollback

    public void testRealizarCompra() {

        Usuario usuario = new Usuario();
        usuario.setPuntos(0);
        session().save(usuario);

        Libro libro = new Libro("pepe", "null", "null");
        session().save(libro);

        Etiqueta etiqueta = new Etiqueta();
        etiqueta.setDescripcion("Terror");

        List<Etiqueta> etiquetas = new ArrayList<>();
        etiquetas.add(etiqueta);

        Publicacion publicacion = new Publicacion(libro, usuario, 500D, etiquetas);
        session().save(publicacion);

        Double precioDeCompra = publicacion.getPrecio();

        Compra compra = new Compra(publicacion, usuario, precioDeCompra);
        session().save(compra);

        assertThat(compra.getId()).isNotNull();

    }

}
