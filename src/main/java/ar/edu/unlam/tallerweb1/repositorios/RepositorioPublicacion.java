package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface RepositorioPublicacion {
    void cargarPublicacion(Publicacion publicacion);
    List<Publicacion> buscarPublicacion(String nombre);
    Publicacion buscarPublicacionPorId(Long id);
    List<Publicacion> listarPublicacionesGenerico();
    List<Publicacion> listarPublicaciones(Usuario usuario);
    List<Publicacion> listarPublicacionesDeUsuario(Usuario usuario);
    void cargarCompra(Compra compra);
    Integer cantidadDeVentas(Long id, Usuario usuario);
    Integer getValorEnPuntos(Publicacion publicacion);
    Integer canjearPuntos(Publicacion publicacion, Usuario usuario, Integer puntosACanjear);
}
