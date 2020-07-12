package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioEtiqueta;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPuntaje;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacion;
import ar.edu.unlam.tallerweb1.servicios.ServicioPublicacionImp;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class RecomendarPublicacionesPorCategoriaTest {
    private RepositorioEtiqueta repositorioEtiqueta;
    private RepositorioPublicacion repositorioPublicacion;
    private RepositorioUsuario repositorioUsuario;
    private RepositorioPuntaje repositorioPuntaje;
    private ServicioPublicacion servicioPublicacion;

    private Usuario usuario1 = new Usuario();
    private Usuario usuario2 = new Usuario();
    private Publicacion publicacion1 = new Publicacion();
    private Publicacion publicacionRecomendada = new Publicacion();
    private Publicacion publicacionPropia = new Publicacion();
    private Etiqueta etiqueta = new Etiqueta();
    private Compra compra1 = new Compra();
    private Compra compraPropia = new Compra();
    private List<Etiqueta> etiquetas = new ArrayList<Etiqueta>();
    private List<Object> etiquetasObj = new ArrayList<Object>();
    private List<Publicacion> publicacionesList = new ArrayList<Publicacion>();
    private List<Publicacion> publicacionesPropiasList = new ArrayList<Publicacion>();
    private List<Compra> compras1 = new ArrayList<Compra>();
    private List<Compra> comprasPropias = new ArrayList<Compra>();
    private List<Long> publicacionesIds = new ArrayList<Long>();
    private List<Long> comprasIds = new ArrayList<Long>();
    private List<Object> etiquetasDescripcion = new ArrayList<>();

    @Before
    public void config() {
        repositorioEtiqueta = mock(RepositorioEtiqueta.class);
        repositorioPublicacion = mock(RepositorioPublicacion.class);
        repositorioUsuario = mock(RepositorioUsuario.class);

        servicioPublicacion = new ServicioPublicacionImp(repositorioPublicacion, repositorioEtiqueta, repositorioUsuario, repositorioPuntaje);

        publicacionesIds.add(3L);
        comprasIds.add(1L);

        usuario1.setId(1L);
        usuario1.setNombre("Luis");
        usuario1.setEmail("luis@gmail.com");

        etiqueta.setDescripcion("Accion");
        etiquetas.add(etiqueta);

        publicacion1.setEtiquetas(etiquetas);
        publicacion1.setId(1L);

        publicacionPropia.setEtiquetas(etiquetas);
        publicacionPropia.setId(3L);
        publicacionesPropiasList.add(publicacionPropia);

        compraPropia.setId(3L);
        comprasPropias.add(compraPropia);

        compra1.setUsuario(usuario1);
        compra1.setPublicacion(publicacion1);
        compras1.add(compra1);

        /*----------------------------------------------------------------*/

        usuario2.setId(2L);
        usuario2.setNombre("Isaias");
        usuario2.setEmail("isaias@gmail.com");

        publicacionRecomendada.setEtiquetas(etiquetas);
        publicacionRecomendada.setId(2L);

        /*----------------------------------------------------------------*/

        etiquetasObj.add(etiqueta);

        publicacionesList.add(publicacionRecomendada);

        etiquetas.forEach(etiqueta -> {
            etiquetasDescripcion.add(etiqueta.getDescripcion());
        });
    }

    @Test
    public void recomendarPublicacacionesDevuelvaRecomendadosTest() {
        when(repositorioEtiqueta.listarEtiquetasporUsuario(usuario1)).thenReturn(etiquetasObj);
        when(repositorioUsuario.getCompras(usuario1)).thenReturn(compras1);
        when(repositorioUsuario.getPublicaciones(usuario1)).thenReturn(publicacionesPropiasList);
        when(repositorioEtiqueta.publicacionesPorEtiquetasPorPublicacion(usuario1, etiquetasDescripcion, comprasIds, publicacionesIds)).thenReturn(publicacionesList);

        List<Publicacion> recomendados = servicioPublicacion.recomendarPublicacionesPorCategoria(usuario1, etiquetas,1L );
        assertThat(recomendados.size()).isNotEqualTo(0);
    }

    @Test
    public void recomendarPublicacacionesUsuarioNoTieneCompras() {
        List<Compra> comprasNull= new ArrayList<>();

        when(repositorioEtiqueta.listarEtiquetasporUsuario(usuario1)).thenReturn(etiquetasObj);
        when(repositorioUsuario.getCompras(usuario1)).thenReturn(comprasNull);
        when(repositorioUsuario.getPublicaciones(usuario1)).thenReturn(publicacionesPropiasList);

        List<Publicacion> recomendados = servicioPublicacion.recomendarPublicacionesPorCategoria(usuario1, etiquetas,1L );
        assertThat(recomendados.size()).isEqualTo(0);
    }

}
