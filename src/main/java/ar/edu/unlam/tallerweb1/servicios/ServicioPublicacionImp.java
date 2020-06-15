package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Etiqueta;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEtiqueta;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPuntaje;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("servicioBuscarLibro")
@Transactional
public class ServicioPublicacionImp implements ServicioPublicacion {

    private RepositorioPublicacion servicioPublicacionDao;
    private RepositorioEtiqueta servicioEtiquetaDao;
    private RepositorioUsuario repositorioUsuarioDao;
    private RepositorioPuntaje repositorioPuntajeDao;



    @Autowired
    public ServicioPublicacionImp(RepositorioPublicacion servicioPublicacionDao, RepositorioEtiqueta servicioEtiquetaDao, RepositorioUsuario repositorioUsuarioDao, RepositorioPuntaje repositorioPuntajeDao){
        this.servicioPublicacionDao = servicioPublicacionDao;
        this.servicioEtiquetaDao = servicioEtiquetaDao;
        this.repositorioUsuarioDao = repositorioUsuarioDao;
        this.repositorioPuntajeDao = repositorioPuntajeDao;
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
    public List<Publicacion> listarPubliacion(Usuario usuario) {
        return servicioPublicacionDao.listarPublicaciones(usuario);
    }

    @Override
    public List<Publicacion> listarPubliacionGenerico() {
        return servicioPublicacionDao.listarPublicacionesGenerico();
    }

    @Override
    public List<Publicacion> recomendarPublicaciones(Usuario user) {
        List<Etiqueta> etiquetas = servicioEtiquetaDao.listarEtiquetasporUsuario(user);

        if (etiquetas.size() == 0)
            return null;

        Set<Etiqueta> hashSet = new HashSet<Etiqueta>(etiquetas);
        etiquetas.clear();
        etiquetas.addAll(hashSet);

        List<Compra> compras = repositorioUsuarioDao.getCompras(user);
        List<Publicacion> publicacionesDeCompras = compras.stream().map(Compra::getPublicacion).collect(Collectors.toList());
        List<Long> publicacionesIds = publicacionesDeCompras.stream().map(Publicacion::getId).collect(Collectors.toList());

        List<Publicacion> publicaciones = servicioEtiquetaDao.publicacionesPorEtiquetas(user, etiquetas, publicacionesIds);

        List<Publicacion> publicacionesPorPuntaje = new ArrayList<Publicacion>();

        for (int i = 0; i < publicaciones.size(); i++){
            double promedio = repositorioPuntajeDao.consultarPuntajePromedio(publicaciones.get(i));
            if (promedio >= 3)
                publicacionesPorPuntaje.add(publicaciones.get(i));
        }
        return publicacionesPorPuntaje;
        }

    @Override
    public List<Publicacion> listarPublicacionDeUsuario(Usuario usuario) {
        return servicioPublicacionDao.listarPublicacionesDeUsuario(usuario);
    }

}
