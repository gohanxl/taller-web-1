package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;

public interface RepositorioLibro {
    Libro consultarLibro(Libro libro);
    void cargarLibro(Libro libro);
    void cargarPublicacion(Publicacion publicacion);
}
