package entidadesDominio;

import java.util.Objects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Silver")
public class Silver extends Categoria {

	private static double precio = 0.75;
	
	public double getPrecio() {
		return precio;
	}

	public static void setPrecio(double precio) {
		Silver.precio = precio;
	}

	public Silver() {
		
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

		return Objects.equals(precio, Silver.precio);
	}

}
