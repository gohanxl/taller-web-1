package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioComprar {
    void comprarLibro(Libro libro_id, Usuario usuario_id);
}
