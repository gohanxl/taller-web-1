package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;

import java.util.List;

public interface RepositorioLibro {
    void cargarLibro(Libro libro);
    
    List<Publicacion> buscarLibro(String nombre);

    Libro buscarLibroPorId(Long id);
}