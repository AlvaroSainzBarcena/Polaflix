package entidadesDominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Factura {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int numeroFactura;
	private Date fecha;
	private double importeTotal;
	@ManyToOne
	private Usuario usuario;
	@OneToMany(mappedBy="factura")
	private List<Visualizacion> visualizaciones=new ArrayList<Visualizacion>();
	
	public Factura(int numeroFactura, Date fecha, double importeTotal, Usuario usuario) {
		this.numeroFactura = numeroFactura;
		this.fecha = fecha;
		this.importeTotal = importeTotal;
		this.usuario = usuario;
	}
	
	// Hay una nueva visualizacion de un capitulo
	public void nuevaVisualizacion(Capitulo capi) {
		
		Date fechaActual=new Date();//fechaActual
		
		@SuppressWarnings("deprecation")
		int dia=fechaActual.getDate();
		@SuppressWarnings("deprecation")
		int mes=fechaActual.getMonth();
		@SuppressWarnings("deprecation")
		int año=fechaActual.getYear();
		String fecha=dia+" "+mes+" "+año;
		
		visualizaciones.add(new Visualizacion(capi,fecha,this));
		
		if(!usuario.isCuotaFija())
			importeTotal=importeTotal+capi.getSerie().getCategoria().getPrecio();	
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(numeroFactura, fecha, importeTotal, usuario, visualizaciones);
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (o == this) return true;
		if (!(o instanceof Factura)) {
			return false;
		}

		Factura fac = (Factura) o;
		return Objects.equals(numeroFactura, fac.numeroFactura) && Objects.equals(fecha, fac.fecha) 
				&& Objects.equals(importeTotal, fac.importeTotal) && Objects.equals(usuario, fac.usuario)
				&& Objects.equals(visualizaciones, fac.visualizaciones);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public int getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public Long getId() {
		return id;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getImporteTotal() {
		return importeTotal;
	}
	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public List<Visualizacion> getVisualizaciones() {
		return visualizaciones;
	}

	public void setVisualizaciones(List<Visualizacion> visualizaciones) {
		this.visualizaciones = visualizaciones;
	}
	
	

}
