package paquete;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) //la superclase manda. No accederé mucho a las subclases
// no tienen nuevos atributos
public abstract class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private final double precio;

	public Categoria(double precio) {
		this.precio=precio;
	}

	public double getPrecio() {
		return precio;
	}

	
	
}
