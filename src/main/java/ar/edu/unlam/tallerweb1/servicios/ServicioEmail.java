package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import javax.mail.MessagingException;
import java.io.IOException;

public interface ServicioEmail {
	void enviarEmail(String destino, String asunto, String texto) throws MessagingException;
	void enviarEmailComprador(Long publicacionId, Usuario usuario) throws MessagingException, IOException;
	void enviarEmailVendedor(Long publicacionId) throws MessagingException, IOException;
	void enviarEmailRegalo(Long publicacionId, Usuario usuario) throws MessagingException, IOException;
}
