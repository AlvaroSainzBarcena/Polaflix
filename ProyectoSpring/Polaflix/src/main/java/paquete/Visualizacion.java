package paquete;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Visualizacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Capitulo capitulo;
	private String fechaVisualizacion;
	@ManyToOne
	private Factura factura;

	public Visualizacion(Capitulo cap, String fecha, Factura factura) {
		this.capitulo=cap;
		this.fechaVisualizacion=fecha;
		this.factura=factura;

	}

	public Capitulo getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}

	public String getFechaVisualizacion() {
		return fechaVisualizacion;
	}

	public void setFechaVisualizacion(String fechaVisualizacion) {
		this.fechaVisualizacion = fechaVisualizacion;
	}
	public Factura getFactua() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

}
