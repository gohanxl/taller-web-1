package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Puntaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	void cargarUsuario(Usuario usuario);

	Usuario consultarUsuario(Usuario usuario);

	Usuario getUsuarioRegalo(String email);

	List<Compra> getCompras(Usuario usuario);

	List<Publicacion> getVentas(Usuario usuario);

	Boolean tieneCompra(Long usuarioId, Long publicacionId);

	List<Puntaje> listarComprasConPuntajePorUsuario(Usuario usuario);

	Boolean tienePublicacion(Long usuarioId, Long publicacionId);

	List<Publicacion> getPublicaciones(Usuario usuario);

	void setPuntosPorCompra(Long usuarioId, Double precioCompra);

	void setPuntosPorVenta(Usuario usuario);

	void setPuntosPorPuntuar(Long usuarioId);
}
