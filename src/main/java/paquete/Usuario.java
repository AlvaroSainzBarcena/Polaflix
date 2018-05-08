package paquete;


import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;


@Entity
public class Usuario {

	@Id
	private String nombreUsuario;
	private String contraseña;
	private String cuentaBancaria;
	private boolean cuotaFija;

	// En este Mapa se guarda el ultimo capitulo de cada serie. No ordenados->Hash
	// La llave es la Serie
	@OneToMany
	private Map<Serie,Capitulo> ultimoCapitulo = new HashMap<Serie,Capitulo>();
	// En este conjunto estaran los capitulos que se hayan visto para mostrarlo cuando se vaya
	// a visualizar un capitulo de una serie.
	@OneToMany
	private Set<Capitulo> capitulosVisualizados = new HashSet<Capitulo>();
	@OneToMany
	private Set<Serie> seriesPendientes = new HashSet<Serie>();
	@OneToMany
	private Set<Serie> seriesTerminadas = new HashSet<Serie>();
	@OneToMany
	private Set<Serie> seriesEmpezadas = new HashSet<Serie>();

	// Conviene que esten ordenadas segun el mes
	// muchas operaciones que necesitan el ultimo elemento insterado (ultima factura)
	// metodo last() devuelve la factura "mas grande". TODO: Implementar el comparteTo en funcion de la fecha
	@OneToMany
	@OrderBy("fecha")
	private SortedSet<Factura> facturasTotales = new TreeSet<Factura>();

	public Usuario(){}
	//TODO ¿Verificar que el nombre del usuario no existe y el formato de ISBAN es correcto aqui?
	public Usuario(String nombreUsuario, String contraseña, String cuentaBancaria, boolean cuotaFija) {
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.cuentaBancaria = cuentaBancaria;
		this.cuotaFija = cuotaFija;
	}

	// El usuario visualiza un capitulo
	//TODO ¿Este metodo va bien aqui, o mejor en la clase Polaflix?
	public void nuevoCapiVisualizado(Capitulo capi) {

		capitulosVisualizados.add(capi); // Si ya estaba visto, no se volvera a a�adir al conjunto
		Serie serie=capi.getSerie();
		marcaUltimoCapi(capi, serie); // marcamos el ultimo capitulo visualizado de la serie

		Factura actual =  facturasTotales.last(); //
		actual.nuevaVisualizacion(capi); //añadimos la visualizacion a la factura		

	}

	// Marca el ultimo capitulo visto de la serie, 
	// reemplazando el anterior si ya existia
	public void marcaUltimoCapi(Capitulo c, Serie s) {

		ultimoCapitulo.put(s, c);
	}

	// a�adir una serie empezada
	public boolean nuevaSerieEmpezada(Serie s) {

		return seriesEmpezadas.add(s);
	}
	// eliminar una serie empezada
	public boolean eliminaSerieEmpezada(Serie s) {

		return seriesEmpezadas.remove(s);
	}
	// a�adir una serie pendiente
	public boolean nuevaSeriePendiente(Serie s) {

		return seriesPendientes.add(s);
	}
	// eliminar una serie pendiente
	public boolean eliminaSeriePendiente(Serie s) {

		return seriesPendientes.remove(s);
	}
	// a�adir una serie terminada
	public boolean nuevaSerieTerminada(Serie s) {

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
