package entidadesDominio;


import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;


@Entity
public class Usuario implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -3666425692470711384L;
	@Id
	private String nombreUsuario;
	private String contraseña;
	private String cuentaBancaria;
	private boolean cuotaFija;

	// En este Mapa se guarda el ultimo capitulo de cada serie. No ordenados->Hash
	// La llave es la Serie
	@ManyToMany
	private Map<Serie,Capitulo> ultimoCapitulo = new HashMap<Serie,Capitulo>();
	// En este conjunto estaran los capitulos que se hayan visto para mostrarlo cuando se vaya
	// a visualizar un capitulo de una serie.
	@ManyToMany
	private Set<Capitulo> capitulosVisualizados = new HashSet<Capitulo>();
	@ManyToMany
	private Set<Serie> seriesPendientes = new HashSet<Serie>();
	@ManyToMany
	private Set<Serie> seriesTerminadas = new HashSet<Serie>();
	@ManyToMany
	private Set<Serie> seriesEmpezadas = new HashSet<Serie>();

	// Conviene que esten ordenadas segun el mes
	// muchas operaciones que necesitan el ultimo elemento insterado (ultima factura)
	// metodo last() devuelve la factura "mas grande". TODO: Implementar el comparteTo en funcion de la fecha
	@OneToMany(mappedBy="usuario")
	@OrderBy("fecha")
	private SortedSet<Factura> facturasTotales = new TreeSet<Factura>();

	public Usuario(){}
	public Usuario(String nombreUsuario, String contraseña, String cuentaBancaria, boolean cuotaFija) {
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.cuentaBancaria = cuentaBancaria;
		this.cuotaFija = cuotaFija;
	}

	// El usuario visualiza un capitulo
	public void nuevoCapiVisualizado(Capitulo capi) {

		capitulosVisualizados.add(capi); // Si ya estaba visto, no se volvera a anhadir al conjunto
		Serie serie=capi.getSerie();
		marcaUltimoCapi(capi, serie); // marcamos el ultimo capitulo visualizado de la serie

		if(facturasTotales.isEmpty()) { // Si no hay facturas aun
			
			Date fechaActual=new Date();
			int numFactura = 0;
			double importeTotal=0;
			Factura fac = new Factura(numFactura,fechaActual, importeTotal, this); // creamos la primera factura
			fac.nuevaVisualizacion(capi); //añadimos la visualizacion a la factura	
			
		}else { // Si ya hay facturas
			Factura actual =  facturasTotales.last(); //
			actual.nuevaVisualizacion(capi); //añadimos la visualizacion a la factura		
		}
	}

	// Devuelve la factura con la fecha indicada
	public Factura muestraFacturaPorFecha(int anio, int mes) {

		for(Factura f: facturasTotales) {
			if(f.getFecha().getYear()==anio && f.getFecha().getMonth()==mes) {
				return f;
			}
		}

		return null;
	}

	// Marca el ultimo capitulo visto de la serie, 
	// reemplazando el anterior si ya existia
	public void marcaUltimoCapi(Capitulo c, Serie s) {

		ultimoCapitulo.put(s, c);
	}

	@Override
	public int hashCode() {

		return Objects.hash(nombreUsuario, contraseña, cuentaBancaria, cuotaFija, ultimoCapitulo, capitulosVisualizados, 
				seriesPendientes, seriesTerminadas, seriesEmpezadas, facturasTotales);
	}

	@Override
	public boolean equals(Object o) {

		if (o == this) return true;
		if (!(o instanceof Usuario)) {
			return false;
		}

		Usuario user = (Usuario) o;
		return Objects.equals(nombreUsuario, user.nombreUsuario) && Objects.equals(contraseña, user.contraseña) 
				&& Objects.equals(cuentaBancaria, user.cuentaBancaria) && Objects.equals(cuotaFija, user.cuotaFija)
				&& Objects.equals(ultimoCapitulo, user.ultimoCapitulo) 
				&& Objects.equals(capitulosVisualizados, user.capitulosVisualizados)
				&& Objects.equals(seriesPendientes, user.seriesPendientes) 
				&& Objects.equals(seriesTerminadas, user.seriesTerminadas)
				&& Objects.equals(seriesEmpezadas, user.seriesEmpezadas) 
				&& Objects.equals(facturasTotales, user.facturasTotales);
	}

	// anhadir una serie empezada
	public boolean nuevaSerieEmpezada(Serie s) {

		if(seriesPendientes.contains(s)) {
			seriesPendientes.remove(s);
		}

		if(seriesTerminadas.contains(s)) {
			seriesTerminadas.remove(s);
		}

		return seriesEmpezadas.add(s); // retorna falso si ya existe
	}
	// eliminar una serie empezada
	public boolean eliminaSerieEmpezada(Serie s) {

		return seriesEmpezadas.remove(s);
	}
	// anhadir una serie pendiente
	public boolean nuevaSeriePendiente(Serie s) {

		if(seriesTerminadas.contains(s)) {
			seriesTerminadas.remove(s);
		}

		if(seriesEmpezadas.contains(s)) {
			seriesEmpezadas.remove(s);
		}

		return seriesPendientes.add(s); // retorna falso si ya existe
	}
	// eliminar una serie pendiente
	public boolean eliminaSeriePendiente(Serie s) {

		return seriesPendientes.remove(s);
	}
	// anhadir una serie terminada
	public boolean nuevaSerieTerminada(Serie s) {

		if(seriesPendientes.contains(s)) {
			seriesPendientes.remove(s);
		}

		if(seriesEmpezadas.contains(s)) {
			seriesEmpezadas.remove(s);
		}


		return seriesTerminadas.add(s);
	}
	// eliminar una serie terminada
	public boolean eliminaSerieTerminada(Serie s){

		return seriesTerminadas.remove(s);
	}

	// eliminar un capitulo visualizado
	public boolean eliminaCapiVisualizado(Capitulo c) {

		return capitulosVisualizados.remove(c);
	}
	// a�ade una nueva factura
	public boolean nuevaFactura(Factura f) {

		return facturasTotales.add(f);
	}
	// elimina una factura
	public boolean elimina(Factura f) {

		return facturasTotales.remove(f);
	}


	/*
	 * Getters y Setters
	 * */
	public Set<Serie> getSeriesPendientes() {
		return seriesPendientes;
	}
	public void setSeriesPendientes(Set<Serie> seriesPendientes) {
		this.seriesPendientes = seriesPendientes;
	}
	public Set<Serie> getSeriesTerminadas() {
		return seriesTerminadas;
	}
	public void setSeriesTerminadas(Set<Serie> seriesTerminadas) {
		this.seriesTerminadas = seriesTerminadas;
	}
	public Set<Serie> getSeriesEmpezadas() {
		return seriesEmpezadas;
	}
	public void setSeriesEmpezadas(Set<Serie> seriesEmpezadas) {
		this.seriesEmpezadas = seriesEmpezadas;
	}
	public SortedSet<Factura> getFacturasTotales() {
		return facturasTotales;
	}
	public void setFacturasTotales(SortedSet<Factura> facturasTotales) {
		this.facturasTotales = facturasTotales;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getCuentaBancaria() {
		return cuentaBancaria;
	}
	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	public boolean isCuotaFija() {
		return cuotaFija;
	}
	public void setCuotaFija(boolean cuotaFija) {
		this.cuotaFija = cuotaFija;
	}
	public Set<Capitulo> getCapitulosVisualizados() {
		return capitulosVisualizados;
	}
	public void setCapitulosVisualizados(Set<Capitulo> capitulosVisualizados) {
		this.capitulosVisualizados = capitulosVisualizados;
	}
	public Map<Serie,Capitulo> getUltimoCapitulo() {
		return ultimoCapitulo;
	}
	public void setUltimoCapitulo(Map<Serie,Capitulo> ultimoCapitulo) {
		this.ultimoCapitulo = ultimoCapitulo;
	}

}
