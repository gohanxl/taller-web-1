package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Libro;

public interface RepositorioLibro {
    Libro consultarLibro(Libro libro);
    void cargarLibro(Libro libro);
}
