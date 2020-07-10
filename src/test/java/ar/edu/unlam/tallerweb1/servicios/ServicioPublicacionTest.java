package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.*;

import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ServicioPublicacionTest {

    private RepositorioEtiqueta servicioEtiquetaDao;
    private RepositorioUsuario repositorioUsuarioDao;
    private RepositorioPuntaje repositorioPuntajeDao;
    private RepositorioPublicacion repositorioPublicacion;
    private ServicioPublicacionImp servicioPublicacion;
    private Usuario usuario = new Usuario();
    private List<Publicacion> publicaciones = new ArrayList<Publicacion>();
    private Publicacion publicacion = new Publicacion();

    @Before
    public void setUp() {


        usuario.setId((long) 1);
        usuario.setEmail("lucas@gmail.com");
        usuario.setPassword("Lucas");
        usuario.setNombre("Lucas");
        usuario.setRol("admin");

        publicaciones.add(publicacion);
        publicaciones.add(publicacion);

        repositorioPublicacion = mock(RepositorioPublicacion.class);
        servicioEtiquetaDao = mock(RepositorioEtiqueta.class);
        repositorioUsuarioDao = mock(RepositorioUsuario.class);
        repositorioPuntajeDao = mock(RepositorioPuntaje.class);

        servicioPublicacion = new ServicioPublicacionImp(repositorioPublicacion, servicioEtiquetaDao, repositorioUsuarioDao, repositorioPuntajeDao);
    }


    @Test
    public void testQueChequeaQueDevuelvaPublicaciones() {

        when(repositorioPublicacion.listarPublicaciones(usuario)).thenReturn(publicaciones);

        List<Publicacion> listaPublicaciones = servicioPublicacion.listarPubliacion(usuario);

        Assert.assertNotNull(listaPublicaciones);
    }

}
