package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
public class Publicacion {
    public Publicacion(){}

    public Publicacion(Date fecha, Libro libro, Usuario propietario, Double precio){
        this.setFecha(fecha);
        this.setLibro(libro);
        this.setPropietario(propietario);
        this.setPrecio(precio);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @ManyToOne()
    private Libro libro;

    @ManyToOne()
    private Usuario propietario;

    @Column(name = "precio", nullable = false)
    private Double precio;

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
}
