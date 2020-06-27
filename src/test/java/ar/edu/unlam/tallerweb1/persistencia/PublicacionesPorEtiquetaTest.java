package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.*;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class PublicacionesPorEtiquetaTest extends SpringTest {

    @Test
    @Transactional
    @Rollback

    public void testObtenerPublicacionesPorEtiqueta() {

        Usuario usuario = new Usuario();
        session().save(usuario);

        Usuario usuario2 = new Usuario();
        session().save(usuario2);

        Libro libro = new Libro("Libro", "null", "null");
        session().save(libro);

        Etiqueta etiqueta = new Etiqueta();
        etiqueta.setDescripcion("Terror");

        List<Etiqueta> etiquetas = new ArrayList<>();
        etiquetas.add(etiqueta);


        Publicacion publicacion = new Publicacion(libro, usuario2, 218.00, etiquetas);
        session().save(publicacion);

        Compra compra = new Compra(publicacion, usuario);
        session().save(compra);

        assertEquals(compra.getUsuario(), usuario);
        assertNotEquals(compra.getUsuario(), usuario2);
        assertEquals(compra.getPublicacion().getEtiquetas().get(0).getDescripcion(),"Terror");
        
    }
}
