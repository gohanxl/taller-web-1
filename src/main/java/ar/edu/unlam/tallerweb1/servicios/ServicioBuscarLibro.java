package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Libro;

import java.io.IOException;
import java.util.List;

public interface ServicioBuscarLibro {
    List<Libro> buscarLibro(String nombre) throws IOException;
}
