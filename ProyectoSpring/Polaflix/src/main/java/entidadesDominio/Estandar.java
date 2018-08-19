package entidadesDominio;

import java.util.Objects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Estandar")
public class Estandar extends Categoria {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5338473694749355018L;
	private static double precio = 0.5;
	
	public double getPrecio() {
		return precio;
	}

	public static void setPrecio(double precio) {
		Estandar.precio = precio;
	}

	public Estandar() {
		super(precio);
		
	}
	
	@Override
	public int hashCode() {

		return Objects.hash(precio);
	}

	@Override
	public boolean equals(Object o) {

		if (o == this) return true;
		if (!(o instanceof Estandar)) {
			return false;
		}

		return Objects.equals(precio, Estandar.precio);
	}

}
