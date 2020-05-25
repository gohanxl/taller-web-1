package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public class CompraTest extends SpringTest {

    @Test
    @Transactional
    @Rollback

    public void testRealizarCompra(){
        
        Usuario usuario = new Usuario();
        Libro libro = new Libro("pepe", "null", "null");
        Publicacion publicacion = new Publicacion(new Date(), libro, usuario, 420.69);

        Compra compra = new Compra(libro, usuario);
    }



}
