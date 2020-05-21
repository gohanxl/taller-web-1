package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;

import java.util.List;

public interface RepositorioPublicacion {
    void cargarPublicacion(Publicacion publicacion);
    List<Publicacion> buscarPublicacion(String nombre);
    List<Publicacion> listarPublicaciones();
    Publicacion buscarPublicacionPorId(Long id);
}
