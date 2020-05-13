package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioComprar")
@Transactional
public class ServicioComprarImp implements ServicioComprar{

    private RepositorioLibro servicioLibroDao;

    @Autowired
    public ServicioComprarImp(RepositorioLibro servicioLibroDao){
        this.servicioLibroDao = servicioLibroDao;
    }

    @Override
    public void comprarLibro(Libro libro_id, Usuario usuario_id){
        Compra compra = new Compra(libro_id, usuario_id);

        servicioLibroDao.cargarCompra(compra);
    }
}
