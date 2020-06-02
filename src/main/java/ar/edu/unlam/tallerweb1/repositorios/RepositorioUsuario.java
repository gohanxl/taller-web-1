package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	void cargarUsuario(Usuario usuario);
	Usuario consultarUsuario (Usuario usuario);
	List <Compra> getCompras (Usuario usuario);
	List <Compra> getVentas (Usuario usuario);
	Boolean tieneCompra(Long id);
}
