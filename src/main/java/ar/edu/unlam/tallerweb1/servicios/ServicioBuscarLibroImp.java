package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.List;

@Service("servicioBuscarLibro")
@Transactional
public class ServicioBuscarLibroImp implements ServicioBuscarLibro {
    @Autowired
    ServletContext context;

    private RepositorioPublicacion servicioPublicacionDao;

    @Autowired
    public ServicioBuscarLibroImp(RepositorioPublicacion servicioPublicacionDao){
        this.servicioPublicacionDao = servicioPublicacionDao;
    }

    @Override
    public List<Publicacion> buscarLibro(String nombre) throws IOException {
        List<Publicacion> publicaciones = servicioPublicacionDao.buscarPublicacion(nombre);
        return publicaciones;
    }

    @Override
    public Publicacion buscarLibroPorId(Long id) throws IOException {
        Publicacion publicacion = servicioPublicacionDao.buscarPublicacionPorId(id);
        return publicacion;
    }

}
