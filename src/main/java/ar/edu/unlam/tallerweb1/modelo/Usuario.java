package ar.edu.unlam.tallerweb1.modelo;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

import javax.persistence.*;

// Clase que modela el concepto de Usuario, la anotacion @Entity le avisa a hibernate que esta clase es persistible
// el paquete ar.edu.unlam.tallerweb1.modelo esta indicado en el archivo hibernateCOntext.xml para que hibernate
// busque entities en el
@Entity
public class Usuario {

	// La anotacion id indica que este atributo es el utilizado como clave primaria de la entity, se indica que el valor es autogenerado.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// para el resto de los atributo no se usan anotaciones entonces se usa el default de hibernate: la columna se llama igual que
	// el atributo, la misma admite nulos, y el tipo de dato se deduce del tipo de dato de java.
	private String email;
	private String password;
	private String rol;
	private String nombre;

	@Column(name = "puntos", nullable = false)
	private Integer puntos;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) { this.rol = rol; }
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) { this.nombre = nombre; }
	public Integer getPuntos() {
		return this.puntos;
	}
	public void setPuntos(Integer puntos) { this.puntos = puntos; }

	public Usuario(String email, String password, String rol, String nombre, Integer puntos){
		this.setEmail(email);
		this.setPassword(password);
		this.setRol(rol);
		this.setNombre(nombre);
		this.setPuntos(puntos);
	}

	public Usuario(){
		this.setPuntos(0);
	}
}
