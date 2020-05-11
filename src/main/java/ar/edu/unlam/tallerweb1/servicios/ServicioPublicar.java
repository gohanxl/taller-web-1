package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ServicioPublicar {
    void subirArchivo(MultipartFile archivo) throws IOException;
}
