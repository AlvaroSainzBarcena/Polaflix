package paquete;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Silver")
public class Silver extends Categoria {

	private final static double precio = 0.75;
	
	public Silver() {
		
		super(precio);
	}

}
