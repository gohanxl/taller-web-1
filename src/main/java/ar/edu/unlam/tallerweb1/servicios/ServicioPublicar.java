package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.modelo.Etiqueta;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ServicioPublicar {
    void subirArchivo(String nombre, Double precio, MultipartFile archivo, MultipartFile imagen, String ruta, Usuario propietario, List<Etiqueta> etiquetas) throws IOException;
    List<Publicacion> listarPubliacion(Usuario user);
    List<Etiqueta> listarEtiquetas();
    List<Etiqueta> parsearEtiquetas(String[] etiquetas);
}
