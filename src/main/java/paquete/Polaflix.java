package paquete;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Polaflix {

	// todos los usuarios de la plataforme
	Set<Usuario> usuarios = new HashSet<Usuario>();
	// quiero las series ordenadas alfabeticamente-> TreeSet
	Set<Serie> series = new TreeSet<Serie>();
	// todos los actores
	Set<Actor> actores = new HashSet<Actor>();
	// todos los creadores
	Set<Creador> creadores = new HashSet<Creador>();

	// Constructor
	public Polaflix() {

		
		
	}
	
	// Metodo que redirige a la interfaz de ver una serie para su visualizacion
	public void verSerie(Usuario user) {
		
		
		
		
	}
	
	// Metodo que muestra la descripcion del capitulo de la serie seleccioanda en 
	// la interfaz verSerie
	public void seleccionaSerie(Usuario user) {
		
		
		
	}
	
	// Metodo que redirige a la interfaz de agregar serie
	// Solo se mostraran series de la misma inicial por pagina y alfabeticamente
	public void agregarSerie(Usuario user) {
		
		
		
	}
	
	
	// El usuario agrega una nueva serie del listado
	public void agregaNuevaSeriePersonal(Usuario user, Serie serie){
		
		// Si ya esta pendiente, no se agregara
		user.nuevaSeriePendiente(serie);
		
	}
	
	// Metodo  que redirige a la interfaz de ver los cargos de las facturas
	public void verCargos(Usuario user) {
		
		
		
		
	}

	// retorna false si ya existe el usuario
	public boolean nuevoUsuario(Usuario u) {
		
		return usuarios.add(u);
	}
	// retorna false si no existe el usuario
	public boolean eliminaUsuario(Usuario u){

		return usuarios.remove(u);
	}

	// retorna false si ya existe el creador
	public boolean nuevoCreador(Creador c) {

		return creadores.add(c);
	}
	// retorna false si no existe el actor
	public boolean eliminaCreador(Creador c){

		return creadores.remove(c);
	}

	// retorna false si ya existe el actor
	public boolean nuevoActor(Actor a) {

		return actores.add(a);
	}
	// retorna false si no existe el actor
	public boolean eliminaActor(Actor a) {

		return actores.remove(a);
	}

	// retorna false si ya existe la serie
	public boolean nuevaSerie(Serie s) {

		return series.add(s);
	}
	// retorna false si no existe la serie
	public boolean eliminaSerie(Serie s) {

		return series.remove(s);
	}
	
	/*
	 * Getters y Setters
	 * */
	
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public Set<Serie> getSeries() {
		return series;
	}
	public void setSeries(Set<Serie> series) {
		this.series = series;
	}
	public Set<Actor> getActores() {
		return actores;
	}
	public void setActores(Set<Actor> actores) {
		this.actores = actores;
	}
	public Set<Creador> getCreadores() {
		return creadores;
	}
	public void setCreadores(Set<Creador> creadores) {
		this.creadores = creadores;
	}

}
