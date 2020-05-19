package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.List;

@Service("servicioBuscarLibro")
@Transactional
public class ServicioBuscarLibroImp implements ServicioBuscarLibro {
    @Autowired
    ServletContext context;

    private RepositorioLibro servicioLibroDao;
    @Autowired
    public ServicioBuscarLibroImp(RepositorioLibro servicioLibroDao){
        this.servicioLibroDao = servicioLibroDao;
    }

    @Override
    public List<Publicacion> buscarLibro(String nombre) throws IOException {
        List<Publicacion> results = servicioLibroDao.buscarLibro(nombre);
        return results;
    }
}
