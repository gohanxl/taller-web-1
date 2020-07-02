package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import javax.mail.MessagingException;

public interface ServicioComprar {
    void comprarLibro(Publicacion publicacion, Usuario usuario);
}
