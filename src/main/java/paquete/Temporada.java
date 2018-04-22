package paquete;

import java.util.TreeSet;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Temporada {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int numeroTemporada;
	// TreeSet para que esten ordenados los capitulos
	@OneToMany
	private Set<Capitulo> capitulos = new TreeSet<Capitulo>();
	
	public Temporada(int numeroTemporada, Set<Capitulo> capitulos) {
	
		this.numeroTemporada = numeroTemporada;
		this.capitulos = capitulos;
	}
	
	public int getNumeroTemporada() {
		return numeroTemporada;
	}
	public void setNumeroTemporada(int numeroTemporada) {
		this.numeroTemporada = numeroTemporada;
	}
	public Set<Capitulo> getCapitulos() {
		return capitulos;
	}
	public void setCapitulos(Set<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}
	//a�ade un capitulo a la temporada
	public boolean nuevoCapitulo(Capitulo c) {
		return capitulos.add(c);
	}
	//borra un capitulo de la temporada
	public boolean eliminaCapitulo(Capitulo c) {
		return capitulos.remove(c);
	}
	
}
