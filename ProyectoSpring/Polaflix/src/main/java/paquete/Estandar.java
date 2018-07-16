package paquete;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Estandar")
public class Estandar extends Categoria {
	
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

}
