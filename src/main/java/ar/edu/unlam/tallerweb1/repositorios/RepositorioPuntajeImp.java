package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Puntaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("repositorioPuntaje")
public class RepositorioPuntajeImp implements RepositorioPuntaje {

	private SessionFactory sessionFactory;

    @Autowired
	public RepositorioPuntajeImp(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void cargarPuntaje(Puntaje puntaje) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(puntaje);
	}

	@Override
	public Double consultarPuntajePromedio(Publicacion publicacion) {
		final Session session = sessionFactory.getCurrentSession();
		return (Double) session.createCriteria(Puntaje.class)
				.add(Restrictions.eq("publicacion.id", publicacion.getId()))
				.setProjection(Projections.avg("valor"))
				.uniqueResult();
	}

	@Override
	public List<Puntaje> listarPuntajes(Publicacion publicacion) {
		final Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Puntaje.class)
				.add(Restrictions.eq("publicacion.id", publicacion.getId()));
		List <Puntaje> puntajes = criteria.list();
		return puntajes;
	}
}
