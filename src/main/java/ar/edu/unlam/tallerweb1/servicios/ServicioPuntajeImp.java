package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Puntaje;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPuntaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioPuntaje")
@Transactional
public class ServicioPuntajeImp implements ServicioPuntaje {

	private RepositorioPuntaje servicioPuntajeDao;

	@Autowired
	public ServicioPuntajeImp(RepositorioPuntaje servicioPuntajeDao){
		this.servicioPuntajeDao = servicioPuntajeDao;
	}

	@Override
	public Double calcularPromedio(Publicacion publicacion) {
		return this.servicioPuntajeDao.consultarPuntajePromedio(publicacion);
	}

	@Override
	public void puntuarPublicacion(Puntaje puntaje) {
		this.servicioPuntajeDao.cargarPuntaje(puntaje);
	}

	@Override
	public List<Puntaje> listarPuntaje(Publicacion publicacion) {
		return this.servicioPuntajeDao.listarPuntajes(publicacion);
	}

	@Override
	public Boolean puntuoPublicacion(Long usuarioId, Long publicacionId){
		return this.servicioPuntajeDao.puntuoPublicacion(usuarioId, publicacionId);
	}
}
