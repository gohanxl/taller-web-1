package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarioImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioUsuarioImpl;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ControladorBibliotecaTest {

    private MockMvc mockMvc;
    private MockHttpSession session;
    private MockHttpServletRequest request;
    private ControladorBiblioteca controladorBiblioteca;
    private ServicioUsuarioImpl servicioUsuario;
    private RepositorioUsuarioImpl repositorioUsuario;
    private Usuario usuario = new Usuario();
    private Gson gson = new Gson();
    private String jsonString;

    @Before
    public void setUp() {

        servicioUsuario = mock(ServicioUsuarioImpl.class);
        repositorioUsuario = mock(RepositorioUsuarioImpl.class);
        session = new MockHttpSession();
        request = new MockHttpServletRequest();
        controladorBiblioteca = new ControladorBiblioteca(servicioUsuario);
        mockMvc = MockMvcBuilders.standaloneSetup((controladorBiblioteca)).build();

        usuario.setId((long) 1);
        usuario.setRol("admin");
        usuario.setNombre("Lucas");
        usuario.setPassword("1234");
        usuario.setEmail("lucas@gmail.com");

        jsonString = gson.toJson(usuario);
    }

    @Test @Transactional @Rollback(true)
    public void testQueChequeaQueSiHayUsuarioVayaABiblioteca() throws Exception {

        session.setAttribute("USUARIO", usuario);

        this.mockMvc.perform(get("/testBiblioteca").session(session)
                .param("request", "mockedRequest")
                .accept(MediaType.ALL))
                .andExpect(status().is2xxSuccessful());
    }

    @Test @Transactional @Rollback(true)
    public void testQueChequeaQueSiHayUsuarioVayaARedirect() throws Exception {

        this.mockMvc.perform(get("/testBiblioteca").session(session)
                .param("request", "mockedRequest")
                .accept(MediaType.ALL))
                .andExpect(status().is3xxRedirection());
    }
}
