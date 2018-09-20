package entidadesDominio;

import java.util.TreeSet;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Temporada implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1818507950005212864L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int numeroTemporada;
	// TreeSet para que esten ordenados los capitulos
	@OneToMany(mappedBy="temporada")
	@JsonIgnore
	private Set<Capitulo> capitulos = new TreeSet<Capitulo>();
	
	@ManyToOne
	@JsonIgnore
	private Serie serie;
	
	public Temporada() {};
	
	public Temporada(int numeroTemporada, Set<Capitulo> capitulos) {
		
		this.numeroTemporada = numeroTemporada;
		this.capitulos = capitulos;
	}
	
	public Capitulo getCapByNumCap(int num) {
		
		for(Capitulo c: capitulos) {
			if(c.getNumeroCapitulo()== num) {
				return c;
			}
		}
		
		return null;
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(numeroTemporada, capitulos);
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (o == this) return true;
		if (!(o instanceof Temporada)) {
			return false;
		}

		Temporada temp = (Temporada) o;
		return Objects.equals(numeroTemporada, temp.numeroTemporada) && Objects.equals(capitulos, temp.capitulos);
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
