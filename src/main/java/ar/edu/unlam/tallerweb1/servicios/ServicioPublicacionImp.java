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
import sun.rmi.runtime.NewThreadAction;

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
    public ServicioPublicacionImp(RepositorioPublicacion servicioPublicacionDao, RepositorioEtiqueta servicioEtiquetaDao, RepositorioUsuario repositorioUsuarioDao, RepositorioPuntaje repositorioPuntajeDao) {
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
        List<Object> etiquetas = servicioEtiquetaDao.listarEtiquetasporUsuario(user);
        List<Publicacion> nullList = new ArrayList<>();

        if (etiquetas.size() == 0)
            return nullList;

        Set<Object> hashSet = new HashSet<Object>(etiquetas);
        etiquetas.clear();
        etiquetas.addAll(hashSet);
        List<Object> etiquetasDescripcion = new ArrayList<>();

        List<Compra> compras = repositorioUsuarioDao.getCompras(user);

            List<Publicacion> publicacionesDeCompras = compras.stream().map(Compra::getPublicacion).collect(Collectors.toList());
            List<Long> publicacionesIds = publicacionesDeCompras.stream().map(Publicacion::getId).collect(Collectors.toList());

            List<Publicacion> publicaciones = servicioEtiquetaDao.publicacionesPorEtiquetas(user, etiquetas, publicacionesIds);

            List<Publicacion> publicacionesPorPuntaje = new ArrayList<Publicacion>();

            for (int i = 0; i < publicaciones.size(); i++) {
                double promedio = repositorioPuntajeDao.consultarPuntajePromedio(publicaciones.get(i));
                if (promedio >= 3)
                    publicacionesPorPuntaje.add(publicaciones.get(i));
            }
            return publicacionesPorPuntaje;
    }

    @Override
    public List<Publicacion> recomendarPublicacionesPorCategoria(Usuario user, List<Etiqueta> etiquetas, Long publicacionId) {

        List<Object> etiquetasDescripcion = new ArrayList<>();
        etiquetas.forEach(etiqueta -> {
            etiquetasDescripcion.add(etiqueta.getDescripcion());
        });

        List<Compra> compras = repositorioUsuarioDao.getCompras(user);
        List<Publicacion> publicaciones = repositorioUsuarioDao.getPublicaciones(user);


        List<Publicacion> publicacionesDeCompras = compras.stream().map(Compra::getPublicacion).collect(Collectors.toList());
        List<Long> publicacionesIds = publicaciones.stream().map(Publicacion::getId).collect(Collectors.toList());
        List<Long> comprasIds = publicacionesDeCompras.stream().map(Publicacion::getId).collect(Collectors.toList());

        if(comprasIds.size() == 0){
            comprasIds.add(0L);
        }

        if(publicacionesIds.size() == 0){
            publicacionesIds.add(0L);
        }

        List<Publicacion> publicacionesPorEtiquetas = servicioEtiquetaDao.publicacionesPorEtiquetasPorPublicacion(user, etiquetasDescripcion, comprasIds, publicacionesIds);

        List<Publicacion> publicacionesPorPuntaje = new ArrayList<Publicacion>();

        for (int i = 0; i < publicacionesPorEtiquetas.size(); i++) {
            publicacionesPorPuntaje.add(publicacionesPorEtiquetas.get(i));
        }

        for (int i = 0; i < publicacionesPorPuntaje.size(); i++) {
            if (publicacionesPorPuntaje.get(i).getId() == publicacionId) {
                publicacionesPorPuntaje.remove(i);
                i--;
            }
        }

        return publicacionesPorPuntaje;
    }

    @Override
    public List<Publicacion> recomendarPublicacionesPorPuntosDisponibles(Usuario user) {
        List<Compra> compras = repositorioUsuarioDao.getCompras(user);
        List<Publicacion> publicaciones = repositorioUsuarioDao.getPublicaciones(user);

        List<Publicacion> publicacionesDeCompras = compras.stream().map(Compra::getPublicacion).collect(Collectors.toList());
        List<Long> publicacionesIds = publicaciones.stream().map(Publicacion::getId).collect(Collectors.toList());
        List<Long> comprasIds = publicacionesDeCompras.stream().map(Publicacion::getId).collect(Collectors.toList());

        if(comprasIds.size() == 0){
            comprasIds.add(0L);
        }

        if(publicacionesIds.size() == 0){
            publicacionesIds.add(0L);
        }

        List<Publicacion> publicacionesPorPuntosDisponibles = servicioPublicacionDao.publicacionesPorPuntosDisponibles(user, comprasIds, publicacionesIds);

        return publicacionesPorPuntosDisponibles;
    }

    @Override
    public List<Publicacion> listarPublicacionesDeUsuario(Usuario usuario) {
        return servicioPublicacionDao.listarPublicacionesDeUsuario(usuario);
    }

    @Override
    public Integer cantidadDeVentas(Long id, Usuario usuario) {
        return servicioPublicacionDao.cantidadDeVentas(id, usuario);
    }

    @Override
    public Integer consultarValorEnPuntos(Publicacion publicacion) {
        return servicioPublicacionDao.getValorEnPuntos(publicacion);
    }

}
