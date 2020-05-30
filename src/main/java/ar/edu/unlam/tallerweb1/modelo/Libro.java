package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "ruta", nullable = false)
    private String ruta;

    @Column(name = "imagen", nullable = false)
    private String imagen;

    @JoinTable(name = "rel_libros_etiquetas",
            joinColumns = @JoinColumn(name = "FK_LIBRO", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "FK_ETIQUETA", referencedColumnName = "id"))
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Etiqueta> etiquetas;

    public Libro() {
    }

    public Libro(String nombre, String ruta, String imagen) {
        this.setNombre(nombre);
        this.setRuta(ruta);
        this.setImagen(imagen);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Set<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(Set<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

}
