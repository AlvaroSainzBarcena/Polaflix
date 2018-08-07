package entidadesDominio;

import java.util.Objects;

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
	
	@Override
	public int hashCode() {

		return Objects.hash(nombre, apellidos);
	}

	@Override
	public boolean equals(Object o) {

		if (o == this) return true;
		if (!(o instanceof Creador)) {
			return false;
		}

		Creador creador = (Creador) o;
		return Objects.equals(nombre, creador.nombre) && Objects.equals(apellidos, creador.apellidos);
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
