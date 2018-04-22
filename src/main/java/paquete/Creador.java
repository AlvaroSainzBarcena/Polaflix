package paquete;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Creador {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nombre;
	private String apellidos;
	
	public Creador(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public Long getId() {
		return id;
	}
	
}
