package ar.edu.unlam.tallerweb1;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.repositorios.*;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacionImp;
import static org.assertj.core.api.Assertions.*;

import com.sun.org.apache.xpath.internal.objects.XObject;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

public class RecomendarPublicacionesTest {
    private RepositorioEtiqueta repositorioEtiqueta;
    private RepositorioPublicacion repositorioPublicacion;
    private RepositorioUsuario repositorioUsuario;
    private RepositorioPuntaje repositorioPuntaje;
    private ServicioPublicacion servicioPublicacion;

    private Usuario usuario1 = new Usuario();
    private Usuario usuario2 = new Usuario();
    private Publicacion publicacion1 = new Publicacion();
    private Publicacion publicacionRecomendada = new Publicacion();
    private Etiqueta etiqueta = new Etiqueta();
    private Puntaje puntaje = new Puntaje();
    private Compra compra1 = new Compra();
    private Compra compra2 = new Compra();
    private List<Etiqueta> etiquetas = new ArrayList<Etiqueta>();
    private List<Object> etiquetasObj = new ArrayList<Object>();
    private List<Publicacion> publicacionesList = new ArrayList<Publicacion>();
    private List<Compra> compras1 = new ArrayList<Compra>();
    private List<Compra> compras2 = new ArrayList<Compra>();
    private List<Long> publicacionesIds = new ArrayList<Long>();

    @Before
    public void config() {
        repositorioEtiqueta = mock(RepositorioEtiqueta.class);
        repositorioPublicacion = mock(RepositorioPublicacion.class);
        repositorioUsuario = mock(RepositorioUsuario.class);
        repositorioPuntaje = mock(RepositorioPuntaje.class);

        servicioPublicacion = new ServicioPublicacionImp(repositorioPublicacion, repositorioEtiqueta, repositorioUsuario, repositorioPuntaje);

        usuario1.setId(1L);
        usuario1.setNombre("Mica");
        usuario1.setEmail("mica@gmail.com");
        usuario1.setPuntos(0);


        etiqueta.setDescripcion("Terror");
        etiquetas.add(etiqueta);

        publicacion1.setEtiquetas(etiquetas);
        publicacion1.setId(1L);

        compra1.setUsuario(usuario1);
        compra1.setPublicacion(publicacion1);
        compras1.add(compra1);

        /*----------------------------------------------------------------*/

        usuario2.setId(2L);
        usuario2.setNombre("Isaias");
        usuario2.setEmail("isaias@gmail.com");
        usuario2.setPuntos(0);


        publicacionRecomendada.setEtiquetas(etiquetas);
        publicacionRecomendada.setId(2L);

        puntaje.setValor(4);
        puntaje.setUsuario(usuario2);
        puntaje.setFecha(new Date());
        puntaje.setPublicacion(publicacionRecomendada);

        compra2.setUsuario(usuario2);
        compra2.setPublicacion(publicacionRecomendada);
        compras2.add(compra2);

        /*----------------------------------------------------------------*/

        etiquetasObj.add(etiqueta);
        publicacionesList.add(publicacionRecomendada);
        publicacionesIds.add(1L);
    }

    @Test
    public void recomendarPublicacacionesDevuelvaRecomendadosTest() {
        when(repositorioEtiqueta.listarEtiquetasporUsuario(usuario1)).thenReturn(etiquetasObj);
        when(repositorioUsuario.getCompras(usuario1)).thenReturn(compras1);
        when(repositorioEtiqueta.publicacionesPorEtiquetas(usuario1, etiquetasObj, publicacionesIds)).thenReturn(publicacionesList);
        when(repositorioPuntaje.consultarPuntajePromedio(any(Publicacion.class))).thenReturn(4.0);

        List<Publicacion> recomendados = servicioPublicacion.recomendarPublicaciones(usuario1);
        assertThat(recomendados.size()).isNotEqualTo(0);
    }

    @Test
    public void recomendarPublicacacionesNoTieneEtiquetasTest() {
        List<Object> etiquetasNull= new ArrayList<Object>();
        when(repositorioEtiqueta.listarEtiquetasporUsuario(usuario1)).thenReturn(etiquetasNull);

        when(repositorioUsuario.getCompras(usuario1)).thenReturn(compras1);
        when(repositorioEtiqueta.publicacionesPorEtiquetas(usuario1, etiquetasObj, publicacionesIds)).thenReturn(publicacionesList);
        when(repositorioPuntaje.consultarPuntajePromedio(any(Publicacion.class))).thenReturn(4.0);

        List<Publicacion> recomendados = servicioPublicacion.recomendarPublicaciones(usuario1);
        assertThat(recomendados.size()).isEqualTo(0);
    }

    @Test
    public void recomendarPublicacacionesPromedioMenorATresTest() {
        when(repositorioEtiqueta.listarEtiquetasporUsuario(usuario1)).thenReturn(etiquetasObj);
        when(repositorioUsuario.getCompras(usuario1)).thenReturn(compras1);
        when(repositorioEtiqueta.publicacionesPorEtiquetas(usuario1, etiquetasObj, publicacionesIds)).thenReturn(publicacionesList);

        when(repositorioPuntaje.consultarPuntajePromedio(any(Publicacion.class))).thenReturn(2.0);

        List<Publicacion> recomendados = servicioPublicacion.recomendarPublicaciones(usuario1);
        assertThat(recomendados.size()).isEqualTo(0);
    }

}
