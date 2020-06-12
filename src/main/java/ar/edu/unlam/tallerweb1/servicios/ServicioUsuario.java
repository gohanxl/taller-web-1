package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

// Interface que define los metodos del Servicio de Usuarios.
public interface ServicioUsuario {
	List<Publicacion> getVentas(Usuario usuario);
	Usuario getUsuarioRegalo (String email);
	List<Compra> getCompras(Usuario usuario);
	Boolean tieneCompra(Long usuarioId, Long publicacionId);
}
