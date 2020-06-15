package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository("repositorioEtiqueta")
public class RepositorioEtiquetaImp implements RepositorioEtiqueta {
    private SessionFactory sessionFactory;
    private RepositorioUsuario repositorioUsuarioDao;

    @Autowired
    public RepositorioEtiquetaImp(SessionFactory sessionFactory, RepositorioUsuario repositorioUsuarioDao) {
        this.sessionFactory = sessionFactory;
        this.repositorioUsuarioDao = repositorioUsuarioDao;
    }

    @Override
    public void cargarEtiqueta(Etiqueta etiqueta) {

    }

    @Override
    public List<Etiqueta> listarEtiquetas() {
        final Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Etiqueta.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Etiqueta> etiquetas = criteria.list();
        return etiquetas;
    }

    @Override
    public List<Etiqueta> parsearEtiquetas(String[] etiquetas) {

        List<Etiqueta> etiquetasList = new ArrayList<>();

        final Session session = sessionFactory.getCurrentSession();
        for (String descripcion : etiquetas) {
            Criteria criteria = session.createCriteria(Etiqueta.class)
                    .add(Restrictions.like("descripcion", descripcion));
            etiquetasList.add((Etiqueta) criteria.uniqueResult());
        }
        return etiquetasList;
    }

    @Override
    public List<Publicacion> recomendarPublicaciones(Usuario user) {

        final Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Compra.class)
        .setProjection(Projections.property("e.descripcion"))
                .createAlias("publicacion", "pu")
                .createAlias("usuario", "u")
                .createAlias("pu.etiquetas", "e")
                .add(Restrictions.eq("u.id", user.getId()))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Etiqueta> etiquetas = criteria.list();

        if(etiquetas.size() == 0)
            return null;

        Set<Etiqueta> hashSet = new HashSet<Etiqueta>(etiquetas);
        etiquetas.clear();
        etiquetas.addAll(hashSet);

        List<Compra> compras = repositorioUsuarioDao.getCompras(user);
        List<Publicacion> publicacionesDeCompras = compras.stream().map(Compra::getPublicacion).collect(Collectors.toList());
        List<Long> publicacionesIds = publicacionesDeCompras.stream().map(Publicacion::getId).collect(Collectors.toList());

        Criteria result = session.createCriteria(Compra.class)
                .setProjection(Projections.property("publicacion"))
                .createAlias("publicacion", "pu")
                .createAlias("usuario", "u")
                .createAlias("pu.etiquetas", "e")
                .createAlias("pu.puntaje", "punt")
                .add(Restrictions.ne("usuario", user))
                .add(Restrictions.not(Restrictions.in("id", publicacionesIds)))
                .add(Restrictions.in("e.descripcion", etiquetas))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Publicacion> publicaciones = result.list();

        List<Publicacion> publicacionesPorPuntaje = new ArrayList<Publicacion>();

        for (int i = 0; i < publicaciones.size(); i++){
            int finalI = i;
            publicaciones.get(i).getPuntaje().forEach(puntaje -> {
                    if(puntaje.getValor() == 3 || puntaje.getValor() == 4 || puntaje.getValor() == 5){
                        publicacionesPorPuntaje.add(publicaciones.get(finalI));
                    }
                });
        }
        return publicacionesPorPuntaje;
    }
}
