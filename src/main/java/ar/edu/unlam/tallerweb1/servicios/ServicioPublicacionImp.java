package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Etiqueta;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEtiqueta;
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
    private RepositorioEtiqueta servicioEtiquetaDao;

    @Autowired
    public ServicioPublicacionImp(RepositorioPublicacion servicioPublicacionDao, RepositorioEtiqueta servicioEtiquetaDao){
        this.servicioPublicacionDao = servicioPublicacionDao;
        this.servicioEtiquetaDao = servicioEtiquetaDao;
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
    public List<Publicacion> recomendarPublicaciones(Usuario user) {
        return servicioEtiquetaDao.recomendarPublicaciones(user);
    }


}
