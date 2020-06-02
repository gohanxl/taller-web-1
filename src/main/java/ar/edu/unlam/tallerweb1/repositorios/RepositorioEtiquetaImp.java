package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Etiqueta;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
