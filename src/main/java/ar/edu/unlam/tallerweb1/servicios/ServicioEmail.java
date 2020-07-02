package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import javax.mail.MessagingException;
import java.io.IOException;

public interface ServicioEmail {
	void enviarEmail(String destino, String asunto, String texto, String image, String pdf) throws MessagingException;
	void enviarEmailComprador(Long publicacionId, Usuario usuario, String url) throws MessagingException, IOException;
	void enviarEmailVendedor(Long publicacionId, String url) throws MessagingException, IOException;
	void enviarEmailRegalo(Long publicacionId, Usuario usuario, String url) throws MessagingException, IOException;
}
