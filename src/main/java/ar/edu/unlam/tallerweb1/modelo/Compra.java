package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Compra {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Publicacion publicacion;

    @ManyToOne
    private Usuario usuario;

    @Column(name = "fecha_compra", nullable = false)
    private Date fecha_compra;

    public Compra(){
    }

    public Compra(Publicacion publicacion, Usuario usuario_id) {
        this.setPublicacion(publicacion);
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

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion_id) {
        this.publicacion = publicacion_id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario_id) {
        this.usuario = usuario_id;
    }
}
