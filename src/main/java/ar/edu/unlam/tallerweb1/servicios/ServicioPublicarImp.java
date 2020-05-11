package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service("servicioPublicar")
public class ServicioPublicarImp implements ServicioPublicar {
    @Autowired
    ServletContext context;

    @Override
    public void subirArchivo(MultipartFile archivo) throws IOException {
        Path path = Paths.get(context.getRealPath("/uploads/") + archivo.getOriginalFilename());
        Files.copy(archivo.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
    }
}
