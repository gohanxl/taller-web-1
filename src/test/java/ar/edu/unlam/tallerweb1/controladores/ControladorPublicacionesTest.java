package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacionImp;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ControladorPublicacionesTest extends SpringTest {

    private MockHttpSession session;
    private MockMvc mockMvc;
    private ServicioPublicacion servicioPublicacion;
    private ServicioUsuario servicioUsuario;
    private ControladorPublicaciones controladorPublicaciones;
    private Usuario usuario = new Usuario();
    private Publicacion publicacion = new Publicacion();
    private List<Publicacion> publicaciones = new ArrayList<Publicacion>();

    @Before
    public void config(){
        servicioUsuario = mock(ServicioUsuarioImpl.class);
        servicioPublicacion = mock(ServicioPublicacionImp.class);
        controladorPublicaciones = new ControladorPublicaciones(servicioUsuario, servicioPublicacion);
        mockMvc = MockMvcBuilders.standaloneSetup((controladorPublicaciones)).build();
        session = new MockHttpSession();

        usuario.setId((long) 1);
        usuario.setRol("admin");
        usuario.setNombre("mica");
        usuario.setPassword("1234");
        usuario.setEmail("mica@gmail.com");
        usuario.setPuntos(0);

        publicaciones.add(publicacion);
        publicaciones.add(publicacion);
    }

    @Test @Transactional @Rollback(true)
    public void testControladorPublicacionesConUsuarioLogueado() throws Exception{
        session.setAttribute("USUARIO", usuario);

        this.mockMvc.perform(get("/testPublicaciones").session(session)
                .param("request", "mockedRequest")
                .accept(MediaType.ALL))
                .andExpect(status().is2xxSuccessful());
    }

    @Test @Transactional @Rollback(true)
    public void testControladorPublicacionesSinUsuarioLogueado() throws Exception{
        this.mockMvc.perform(get("/publicaciones").session(session)
                .param("request", "mockedRequest")
                .accept(MediaType.ALL))
                .andExpect(status().is3xxRedirection());
    }
}


