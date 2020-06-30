package ar.edu.unlam.tallerweb1;

import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.repositorios.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RecomendarPublicacionesTest {
    private RepositorioEtiqueta repositorioEtiqueta;
    private RepositorioPublicacion repositorioPublicacion;
    private RepositorioUsuario repositorioUsuario;
    private RepositorioPuntaje repositorioPuntaje;

    private Usuario usuario = new Usuario();
    private Publicacion publicacion = new Publicacion();
    private Etiqueta etiqueta = new Etiqueta();
    private Puntaje puntaje = new Puntaje();
    private Compra compra = new Compra();
    private List<Etiqueta> etiquetas = new ArrayList<Etiqueta>();
    private List<Object> etiquetasObj = new ArrayList<Object>();
    private List<Publicacion> publicacionesList = new ArrayList<Publicacion>();
    private List<Compra> compras = new ArrayList<Compra>();

    @Before
    public void config(){
        repositorioEtiqueta = mock(RepositorioEtiqueta.class);
        repositorioPublicacion = mock(RepositorioPublicacion.class);
        repositorioUsuario = mock(RepositorioUsuario.class);
        repositorioPuntaje = mock(RepositorioPuntaje.class);

        usuario.setId((long) 1);
        usuario.setNombre("mica");
        usuario.setEmail("mica@gmail.com");

        etiqueta.setDescripcion("Terror");
        etiquetas.add(etiqueta);

        publicacion.setEtiquetas(etiquetas);
        publicacionesList.add(publicacion);
        publicacionesList.add(publicacion);

        compra.setUsuario(usuario);
        compra.setPublicacion(publicacion);
        compras.add(compra);
    }

    @Test
    public void recomendarPublicacacionesDevuelvaPublicacionesConMismaEtiqueta(){
        when(repositorioEtiqueta.listarEtiquetasporUsuario(usuario)).thenReturn(etiquetasObj);
        List<Object> etiquetas = repositorioEtiqueta.listarEtiquetasporUsuario(usuario);

        Set<Object> hashSet = new HashSet<Object>(etiquetas);
        etiquetas.clear();
        etiquetas.addAll(hashSet);

        when(repositorioUsuario.getCompras(usuario)).thenReturn(compras);
        List<Compra> compras = repositorioUsuario.getCompras(usuario);
        List<Publicacion> publicacionesDeCompras = compras.stream().map(Compra::getPublicacion).collect(Collectors.toList());
        List<Long> publicacionesIds = publicacionesDeCompras.stream().map(Publicacion::getId).collect(Collectors.toList());

        when(repositorioEtiqueta.publicacionesPorEtiquetas(usuario, etiquetas, publicacionesIds)).thenReturn(publicacionesList);
        List<Publicacion> publicaciones = repositorioEtiqueta.publicacionesPorEtiquetas(usuario, etiquetas, publicacionesIds);

        List<Publicacion> publicacionesPorPuntaje = new ArrayList<Publicacion>();

        for (int i = 0; i < publicaciones.size(); i++){
            Set<Puntaje> valor = publicacionesList.get(i).getPuntaje();
            when(repositorioPuntaje.consultarPuntajePromedio(publicaciones.get(i))).thenReturn((double) 4);
            double promedio = repositorioPuntaje.consultarPuntajePromedio(publicaciones.get(i));
            if (promedio >= 3)
                publicacionesPorPuntaje.add(publicaciones.get(i));
        }

        for (int i = 0; i < publicacionesPorPuntaje.size(); i++) {
            String etiquetaDeRecomendacion = publicacionesPorPuntaje.get(i).getEtiquetas().get(0).getDescripcion();
            String etiquetaDeCompra = compras.get(0).getPublicacion().getEtiquetas().get(0).getDescripcion();

            Assert.assertEquals(etiquetaDeCompra, etiquetaDeRecomendacion);
        }
    }

}
