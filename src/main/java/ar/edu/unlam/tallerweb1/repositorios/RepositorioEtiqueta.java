package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.*;

import java.util.List;

public interface RepositorioEtiqueta {
    void cargarEtiqueta(Etiqueta etiqueta);

    List<Etiqueta> listarEtiquetas();
    List<Etiqueta> parsearEtiquetas(String[] etiquetas);
    List<Publicacion> recomendarPublicaciones(Usuario user);
}