package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Etiqueta;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.io.IOException;
import java.util.List;

public interface ServicioPublicacion {
    List<Publicacion> buscarPublicacion(String nombre) throws IOException;
    Publicacion buscarPublicacionPorId(Long id) throws IOException;
    List<Publicacion> listarPubliacion(Usuario user);
    List<Publicacion> listarPubliacionGenerico();
    List<Publicacion> listarPublicacionesDeUsuario(Usuario usuario);
    List<Publicacion> recomendarPublicaciones(Usuario user);
    List<Publicacion> recomendarPublicacionesPorCategoria(Usuario user, List<Etiqueta> etiquetas, Long publicacionId);
    Integer cantidadDeVentas(Long id, Usuario usuario);
}
