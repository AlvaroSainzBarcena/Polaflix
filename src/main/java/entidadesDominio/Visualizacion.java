package entidadesDominio;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Visualizacion implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8286519085556042710L;
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
	
	@Override
	public int hashCode() {
		
		return Objects.hash(capitulo, fechaVisualizacion, factura);
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (o == this) return true;
		if (!(o instanceof Visualizacion)) {
			return false;
		}

		Visualizacion vis = (Visualizacion) o;
		return Objects.equals(capitulo, vis.capitulo) && Objects.equals(fechaVisualizacion, vis.fechaVisualizacion)
				&& Objects.equals(factura, vis.factura);
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
