package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;

import java.util.List;

public interface RepositorioLibro {
    Libro consultarLibro(Libro libro);
    void cargarLibro(Libro libro);
    void cargarCompra(Compra compra);
    void cargarPublicacion(Publicacion publicacion);
    List<Publicacion> buscarLibro(String nombre);
    Libro buscarLibro(Long id);
}
