package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLibro;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("servicioComprar")
@Transactional
public class ServicioComprarImp implements ServicioComprar{

    private RepositorioPublicacion servicioPublicacionDao;

    @Autowired
    public ServicioComprarImp(RepositorioLibro servicioLibroDao){
        this.servicioPublicacionDao = servicioPublicacionDao;
    }

    @Override
    public void comprarLibro(Publicacion publicacion_id, Usuario usuario_id){
        Compra compra = new Compra(publicacion_id, usuario_id);

        servicioPublicacionDao.cargarCompra(compra);
    }
}
