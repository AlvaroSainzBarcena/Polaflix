package paquete;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Estandar")
public class Estandar extends Categoria {
	
	private final static double precio = 0.5;
	
	public Estandar() {
		super(precio);
		
	}

}
