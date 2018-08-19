package entidadesDominio;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Actor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5627938176387355118L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

	private String nombre;
	private String apellidos;

	public Actor() {};
	
	public Actor(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	@Override
	public int hashCode() {
		/** TODO Esta es otra forma de calcular el codigo hash, creo que con mas margen de error ¿?¿?
		int prime=17;
		int result=1;

		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());	

		return result;
		 */
		return Objects.hash(nombre, apellidos);
	}

	@Override
	public boolean equals(Object o) {

		if (o == this) return true;
		if (!(o instanceof Actor)) {
			return false;
		}

		Actor actor = (Actor) o;
		return Objects.equals(nombre, actor.nombre) && Objects.equals(apellidos, actor.apellidos);
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


}
