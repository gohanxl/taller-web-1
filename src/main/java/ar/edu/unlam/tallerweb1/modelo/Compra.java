package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Compra {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Libro libro_id;

    @ManyToOne
    private Usuario usuario_id;

    @Column(name = "fecha_compra", nullable = false)
    private Date fecha_compra;

    public Compra(){
    }

    public Compra(Libro libro_id, Usuario usuario_id) {
        this.setUsuario_id(usuario_id);
        this.setLibro_id(libro_id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Libro getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(Libro libro_id) {
        this.libro_id = libro_id;
    }

    public Usuario getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Usuario usuario_id) {
        this.usuario_id = usuario_id;
    }
}
