package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
    public List<Etiqueta> recomendarPublicaciones(Usuario user) {

        final Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Compra.class)
        .setProjection(Projections.property("e.descripcion"))
                .createAlias("publicacion", "pu")
                .createAlias("usuario", "u")
                .createAlias("pu.etiquetas", "e")
                .add(Restrictions.eq("u.id", user.getId()))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Etiqueta> etiquetas = criteria.list();

        Set<Etiqueta> hashSet = new HashSet<Etiqueta>(etiquetas);
        etiquetas.clear();
        etiquetas.addAll(hashSet);

        Criteria result = session.createCriteria(Compra.class)
                .setProjection(Projections.property("pu.id"))
                .createAlias("publicacion", "pu")
                .createAlias("usuario", "u")
                .createAlias("pu.etiquetas", "e")
                .add(Restrictions.not(Restrictions.eq("u.id", user.getId())))
                .add(Restrictions.in("e.descripcion", etiquetas))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Etiqueta> etiquetas2 = result.list();

        return etiquetas;
    }
}
