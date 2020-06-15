package ar.edu.unlam.tallerweb1.modelo;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Publicacion {
    public Publicacion(){}

    public Publicacion(Libro libro, Usuario propietario, Double precio, List<Etiqueta> etiquetas){
        this.setFecha(new Date());
        this.setLibro(libro);
        this.setPropietario(propietario);
        this.setPrecio(precio);
        this.setEtiquetas(etiquetas);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @OneToOne()
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Libro libro;

    @ManyToOne()
    private Usuario propietario;

    @JoinTable(name = "rel_publicacion_etiquetas",
            joinColumns = @JoinColumn(name = "FK_PUBLICACION", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "FK_ETIQUETA", referencedColumnName = "id"))
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Etiqueta> etiquetas;

    @Column(name = "precio", nullable = false)
    private Double precio;

    @OneToMany(mappedBy="publicacion")
    private Set<Puntaje> puntaje;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getPropietario() {
        return propietario;
    }

    public void setPropietario(Usuario propietario) {
        this.propietario = propietario;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public Set<Puntaje> getPuntaje() { return puntaje; }

    public void setPuntaje(Set<Puntaje> puntaje) { this.puntaje = puntaje;}

}
