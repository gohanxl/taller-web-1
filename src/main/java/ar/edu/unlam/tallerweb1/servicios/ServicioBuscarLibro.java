package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;

import java.io.IOException;
import java.util.List;

public interface ServicioBuscarLibro {
    List<Publicacion> buscarLibro(String nombre) throws IOException;
}
