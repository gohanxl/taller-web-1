package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Compra {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Libro libro;

    @ManyToOne
    private Usuario usuario;

    @Column(name = "fecha_compra", nullable = false)
    private Date fecha_compra;

    public Compra(){
    }

    public Compra(Libro libro_id, Usuario usuario_id) {
        this.setLibro(libro_id);
        this.setUsuario(usuario_id);
        this.setFecha_compra(new Date());
    }

    public Long getId() {
        return id;
    }

    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro_id) {
        this.libro = libro_id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario_id) {
        this.usuario = usuario_id;
    }
}
