package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLibro;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;

@Service("servicioComprar")
@Transactional
public class ServicioComprarImp implements ServicioComprar{

    private RepositorioPublicacion servicioPublicacionDao;

    private RepositorioUsuario servicioUsuarioDao;

    @Autowired
    public ServicioComprarImp(RepositorioLibro servicioLibroDao, RepositorioPublicacion servicioPublicacionDao, RepositorioUsuario servicioUsuarioDao){
        this.servicioPublicacionDao = servicioPublicacionDao;
        this.servicioUsuarioDao = servicioUsuarioDao;
    }

    @Override
    public void comprarLibro(Publicacion publicacion, Usuario usuario, Double precioDeCompra){
        Compra compra = new Compra(publicacion, usuario, precioDeCompra);
        servicioPublicacionDao.cargarCompra(compra);

        servicioUsuarioDao.setPuntosPorCompra(usuario.getId(), publicacion.getPrecio());
        servicioUsuarioDao.setPuntosPorVenta(publicacion.getPropietario());

    }
}
