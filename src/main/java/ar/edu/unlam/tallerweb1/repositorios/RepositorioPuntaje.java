package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Puntaje;

import java.util.List;

public interface RepositorioPuntaje {
	void cargarPuntaje(Puntaje puntaje);
	Double consultarPuntajePromedio(Publicacion publicacion);
	List<Puntaje> listarPuntajes(Publicacion publicacion);
	Boolean puntuoPublicacion(Long usuarioId, Long publicacionId);
}
