package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Etiqueta;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;

import java.util.List;

public interface RepositorioEtiqueta {
    void cargarEtiqueta(Etiqueta etiqueta);

    List<Etiqueta> listarEtiquetas();
    List<Etiqueta> parsearEtiquetas(String[] etiquetas);
}