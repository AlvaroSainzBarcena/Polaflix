package paquete;

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

	public double getPrecio() {
		return precio;
	}

}
