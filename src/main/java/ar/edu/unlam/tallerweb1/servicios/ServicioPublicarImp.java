package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLibro;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;

@Service("servicioPublicar")
@Transactional
public class ServicioPublicarImp implements ServicioPublicar {
    @Autowired
    ServletContext context;

    private RepositorioLibro servicioLibroDao;
    private RepositorioUsuario servicioUsuarioDao;
    @Autowired
    public ServicioPublicarImp(RepositorioLibro servicioLibroDao, RepositorioUsuario servicioUsuarioDao){
        this.servicioUsuarioDao = servicioUsuarioDao;
        this.servicioLibroDao = servicioLibroDao;
    }

    @Override
    public void subirArchivo(String nombre, Double precio, MultipartFile archivo) throws IOException {
        Path ruta = Paths.get(context.getRealPath("/uploads/") + archivo.getOriginalFilename());
        Files.copy(archivo.getInputStream(), ruta, StandardCopyOption.REPLACE_EXISTING);
        Usuario propiestario = new Usuario("email.com", "123", "Rol");
        servicioUsuarioDao.cargarUsuario(propiestario);
        Libro libro = new Libro(nombre, ruta.toString());
        Publicacion publicacion = new Publicacion(new Date(), libro, propiestario, precio);
        servicioLibroDao.cargarLibro(libro);
        servicioLibroDao.cargarPublicacion(publicacion);
    }
}
