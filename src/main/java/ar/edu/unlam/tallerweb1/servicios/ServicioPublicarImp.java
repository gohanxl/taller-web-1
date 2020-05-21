package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLibro;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
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
import java.util.List;

@Service("servicioPublicar")
@Transactional
public class ServicioPublicarImp implements ServicioPublicar {
    @Autowired
    ServletContext context;

    private RepositorioLibro servicioLibroDao;
    private RepositorioUsuario servicioUsuarioDao;
    private RepositorioPublicacion servicioPublicacionDao;

    @Autowired
    public ServicioPublicarImp(RepositorioLibro servicioLibroDao, RepositorioUsuario servicioUsuarioDao, RepositorioPublicacion servicioPublicacionDao){
        this.servicioUsuarioDao = servicioUsuarioDao;
        this.servicioLibroDao = servicioLibroDao;
        this.servicioPublicacionDao = servicioPublicacionDao;
    }

    @Override
    public void subirArchivo(String nombre, Double precio, MultipartFile archivo) throws IOException {
        Path ruta = Paths.get(context.getRealPath("/uploads/") + archivo.getOriginalFilename());
        String path = "/uploads/" + archivo.getOriginalFilename();
        Files.copy(archivo.getInputStream(), ruta, StandardCopyOption.REPLACE_EXISTING);
        Usuario propiestario = new Usuario("email.com", "123", "Rol","User1");
        servicioUsuarioDao.cargarUsuario(propiestario);
        Libro libro = new Libro(nombre, path);
        Publicacion publicacion = new Publicacion(new Date(), libro, propiestario, precio);
        servicioLibroDao.cargarLibro(libro);
        servicioPublicacionDao.cargarPublicacion(publicacion);
    }

    @Override
    public List<Publicacion> listarPubliacion() {
        return servicioPublicacionDao.listarPublicaciones();
    }
}
