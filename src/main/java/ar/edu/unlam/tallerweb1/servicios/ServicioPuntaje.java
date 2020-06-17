package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Puntaje;

import java.util.List;

public interface ServicioPuntaje {

	Double calcularPromedio(Publicacion publicacion);
	void puntuarPublicacion(Puntaje puntaje);
	List<Puntaje> listarPuntaje(Publicacion publicacion);
	Boolean puntuoPublicacion(Long usuarioId, Long publicacionId);
}
