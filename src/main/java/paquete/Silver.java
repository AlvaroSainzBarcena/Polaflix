package paquete;

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

}
