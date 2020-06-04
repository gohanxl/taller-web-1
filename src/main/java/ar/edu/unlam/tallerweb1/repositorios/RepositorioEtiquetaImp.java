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

@Repository("repositorioEtiqueta")
public class RepositorioEtiquetaImp implements RepositorioEtiqueta {
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioEtiquetaImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void cargarEtiqueta(Etiqueta etiqueta) {

    }

    @Override
    public List<Etiqueta> listarEtiquetas() {
        final Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Etiqueta.class);
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

        Criteria result = session.createCriteria(Compra.class)
                .setProjection(Projections.property("publicacion"))
                .createAlias("publicacion", "pu")
                .createAlias("usuario", "u")
                .createAlias("pu.etiquetas", "e")
                .add(Restrictions.in("e.descripcion", etiquetas))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Publicacion> publicaciones = result.list();

        return publicaciones;
    }
}
