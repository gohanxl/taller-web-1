package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service("servicioBuscarLibro")
@Transactional
public class ServicioPublicacionImp implements ServicioPublicacion {

    private RepositorioPublicacion servicioPublicacionDao;

    @Autowired
    public ServicioPublicacionImp(RepositorioPublicacion servicioPublicacionDao){
        this.servicioPublicacionDao = servicioPublicacionDao;
    }

    @Override
    public List<Publicacion> buscarPublicacion(String nombre) throws IOException {
        List<Publicacion> publicaciones = servicioPublicacionDao.buscarPublicacion(nombre);
        return publicaciones;
    }

    @Override
    public Publicacion buscarPublicacionPorId(Long id) throws IOException {
        Publicacion publicacion = servicioPublicacionDao.buscarPublicacionPorId(id);
        return publicacion;
    }

    @Override
    public List<Publicacion> listarPubliacion() {
        return servicioPublicacionDao.listarPublicaciones();
    }

    @Override
    public List<Publicacion> listarPublicacionDeUsuario(Usuario usuario) {
        return servicioPublicacionDao.listarPublicacionesDeUsuario(usuario);
    }

}
