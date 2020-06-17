package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.*;

import java.util.List;

public interface RepositorioEtiqueta {
    void cargarEtiqueta(Etiqueta etiqueta);

    List<Etiqueta> listarEtiquetas();
    List<Etiqueta> parsearEtiquetas(String[] etiquetas);
    List<Etiqueta> listarEtiquetasporUsuario(Usuario user);
    List<Publicacion> publicacionesPorEtiquetas(Usuario user, List<Etiqueta> etiquetas, List<Long> publicacionesIds);
}