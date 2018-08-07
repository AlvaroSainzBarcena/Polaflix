package entidadesDominio;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Serie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@OneToOne
	private Categoria categoria;
	private String nombreSerie;
	private char inicial; //Letra inicial del nombre de la serie
	@OneToMany
	private Set<Creador> creadores = new HashSet<Creador>();
	// TreeSet para que esten ordenadas las temporadas
	@OneToMany
	private Set<Temporada> temporadas = new TreeSet<Temporada>();
	@OneToMany
	private Set<Actor> actoresPrincipales = new HashSet<Actor>();
	
	// TODO ¿Es necesario que la serie tenga capitulos, si ya tiene temporadas?
	@OneToMany
	private Set<Capitulo> capitulos = new HashSet<Capitulo>();
	
	public Serie() {}
	
	public Serie(Categoria categoria, String nombreSerie, Set<Creador> creadores,
			Set<Temporada> temporadas, Set<Actor> actoresPrincipales, Set<Capitulo> capitulos) {
		super();
		this.categoria = categoria;
		this.nombreSerie = nombreSerie;
		inicial=nombreSerie.charAt(0);
		this.creadores = creadores;
		this.temporadas = temporadas;
		this.actoresPrincipales = actoresPrincipales;
		this.capitulos = capitulos;
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(categoria, nombreSerie, creadores, temporadas, actoresPrincipales, capitulos);
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (o == this) return true;
		if (!(o instanceof Serie)) {
			return false;
		}

		Serie serie = (Serie) o;
		return Objects.equals(categoria, serie.categoria) && Objects.equals(nombreSerie, serie.nombreSerie) 
				&& Objects.equals(creadores, serie.creadores) && Objects.equals(temporadas, serie.temporadas)
				&& Objects.equals(actoresPrincipales, serie.actoresPrincipales) && Objects.equals(capitulos, serie.capitulos);
	}
	
	public Set<Capitulo> getCapitulos() {
		return capitulos;
	}
	public void setCapitulos(Set<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public void setNombreSerie(String nombreSerie) {
		this.nombreSerie = nombreSerie;
		inicial=nombreSerie.charAt(0);
	}
	public String getNombreSerie() {
		return nombreSerie;
	}
	public char getInicial() {
		return inicial;
	}
	public void setInicial(char inicial) {
		this.inicial = inicial;
	}
	

	public Set<Temporada> getTemporadas() {
		return temporadas;
	}
	public void setTemporadas(Set<Temporada> temporadas) {
		this.temporadas = temporadas;
	}
	public Set<Actor> getActoresPrincipales() {
		return actoresPrincipales;
	}
	public void setActoresPrincipales(Set<Actor> actoresPrincipales) {
		this.actoresPrincipales = actoresPrincipales;
	}
	public Set<Creador> getCreadores() {
		return creadores;
	}
	public void setCreadores(Set<Creador> creadores) {
		this.creadores = creadores;
	}
	public Long getId() {
		return id;
	}
	
	
}