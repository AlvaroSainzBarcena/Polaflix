package paquete;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Factura {

	private int id;
	private Date fecha;
	private double importeTotal;
	private Usuario usuario;
	private Set<Visualizacion> visualizaciones=new HashSet<Visualizacion>();
	
	public Factura(int id, Date fecha, double importeTotal, Usuario usuario) {
		this.id = id;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public Set<Visualizacion> getVisualizaciones() {
		return visualizaciones;
	}

	public void setVisualizaciones(Set<Visualizacion> visualizaciones) {
		this.visualizaciones = visualizaciones;
	}
	

}
