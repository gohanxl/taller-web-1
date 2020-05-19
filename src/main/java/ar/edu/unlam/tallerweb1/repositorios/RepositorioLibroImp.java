package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioLibro")
public class RepositorioLibroImp implements RepositorioLibro {
    private SessionFactory sessionFactory;

    @Autowired
    public RepositorioLibroImp(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Libro consultarLibro(Libro libro) {
        return null;
    }

    @Override
    public void cargarLibro(Libro libro) {
        final Session session = sessionFactory.getCurrentSession();
        session.save(libro);
    }

    @Override
    public void cargarCompra(Compra compra) {
        final Session session = sessionFactory.getCurrentSession();
        session.save(compra);
    }

    @Override
    public void cargarPublicacion(Publicacion publicacion) {
        final Session session = sessionFactory.getCurrentSession();
        session.save(publicacion);
    }

    @Override
    public List <Publicacion> buscarLibro(String nombre) {
        final Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(Publicacion.class)
                .createAlias("libro", "l")
                .createAlias("propietario", "p")
                .add(Restrictions.like("l.nombre", "%" + nombre + "%"));
        List <Publicacion> Publicacion = criteria.list();
        return Publicacion;
    }
}
