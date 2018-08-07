package entidadesDominio;

import java.util.Objects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Gold")
public class Gold extends Categoria {

	private static double precio = 1.5;
	
	public static void setPrecio(double precio) {
		Gold.precio = precio;
	}

	public Gold() {
		
		super(precio);
		
	}
	
	@Override
	public int hashCode() {

		return Objects.hash(precio);
	}

	@Override
	public boolean equals(Object o) {

		if (o == this) return true;
		if (!(o instanceof Gold)) {
			return false;
		}

		return Objects.equals(precio, Gold.precio);
	}

	public double getPrecio() {
		return precio;
	}

}
