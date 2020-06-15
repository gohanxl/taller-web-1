package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Puntaje;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// Implelemtacion del Servicio de usuarios, la anotacion @Service indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.servicios
// para encontrar esta clase.
// La anotacion @Transactional indica que se debe iniciar una transaccion de base de datos ante la invocacion de cada metodo del servicio,
// dicha transaccion esta asociada al transaction manager definido en el archivo spring-servlet.xml y el mismo asociado al session factory definido
// en hibernateCOntext.xml. De esta manera todos los metodos de cualquier dao invocados dentro de un servicio se ejecutan en la misma transaccion
@Service("servicioUsuario")
@Transactional
public class ServicioUsuarioImpl implements ServicioUsuario {

    private RepositorioUsuario servicioUsuarioDao;

    @Autowired
    public ServicioUsuarioImpl(RepositorioUsuario servicioLoginDao) {
        this.servicioUsuarioDao = servicioLoginDao;
    }

    @Override
    public List<Compra> getCompras(Usuario usuario) {
        return servicioUsuarioDao.getCompras(usuario);
    }

    @Override
    public List<Publicacion> getVentas(Usuario usuario) {
        return servicioUsuarioDao.getVentas(usuario);
    }

    @Override
    public Boolean tieneCompra(Long usuarioId, Long publicacionId) {
        return servicioUsuarioDao.tieneCompra(usuarioId, publicacionId);
    }

    @Override
    public List<Puntaje> listarComprasConPuntajePorUsuario(Usuario usuario) {
        return servicioUsuarioDao.listarComprasConPuntajePorUsuario(usuario);
    }

    @Override
    public Usuario getUsuarioRegalo(String email) {
        return servicioUsuarioDao.getUsuarioRegalo(email);
    }
}

