package paquete;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Gold")
public class Gold extends Categoria {

	private final static double precio = 1.5;
	
	public Gold() {
		
		super(precio);
		
	}

}
