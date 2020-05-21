package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioPublicacion")
public class RepositorioPublicacionImp implements RepositorioPublicacion {
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioPublicacionImp(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void cargarPublicacion(Publicacion publicacion) {
        final Session session = sessionFactory.getCurrentSession();
        session.save(publicacion);
    }

    @Override
    public List <Publicacion> buscarPublicacion(String nombre) {
        final Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Publicacion.class)
                .createAlias("libro", "l")
                .createAlias("propietario", "p")
                .add(Restrictions.like("l.nombre", "%" + nombre + "%"));
        List <Publicacion> publicaciones = criteria.list();
        return publicaciones;
    }

    @Override
    public List<Publicacion> listarPublicaciones() {
        final Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Publicacion.class);
        List <Publicacion> publicaciones = criteria.list();
        return publicaciones;
    }

    @Override
    public Publicacion buscarPublicacionPorId(Long id) {
        final Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Publicacion.class).add(Restrictions.idEq(id));
        Publicacion publicacion = (Publicacion) criteria.uniqueResult();
        return publicacion;
    }
}
