package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Puntaje {
    public Puntaje(){}

    public Puntaje(Publicacion publicacion, Integer valor, String comentario, Usuario usuario){
        this.setFecha(new Date());
        this.setPublicacion(publicacion);
        this.setValor(valor);
        this.setComentario(comentario);
        this.setUsuario(usuario);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    private Publicacion publicacion;

    @ManyToOne()
    private Usuario usuario;

    private Integer valor;

    private Date fecha;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    private String comentario;

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer puntaje) {
        this.valor = puntaje;
    }
}
