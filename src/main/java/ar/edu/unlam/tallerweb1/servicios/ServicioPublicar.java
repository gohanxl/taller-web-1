package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ServicioPublicar {
    void subirArchivo(String nombre, Double precio, MultipartFile archivo, MultipartFile imagen, String ruta, Usuario propietario) throws IOException;
}
