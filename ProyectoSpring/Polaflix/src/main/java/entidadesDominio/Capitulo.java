package entidadesDominio;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Capitulo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9098201823073040443L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private int numeroCapitulo;
	private String titulo;
	private String descripcion;
	private String enlace;
	@ManyToOne
	@JsonIgnore
	private Serie serie;
	@ManyToOne
	@JsonIgnore
	private Temporada temporada;
	
	public Capitulo() {};
	
	public Capitulo(int numeroCapitulo, String titulo, String descripcion, String enlace,
			Serie serie, Temporada temporada) {
		super();
		this.numeroCapitulo = numeroCapitulo;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.enlace = enlace;
		this.serie = serie;
		this.temporada = temporada;
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(numeroCapitulo, titulo, descripcion, enlace, serie, temporada);
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (o == this) return true;
		if (!(o instanceof Capitulo)) {
			return false;
		}

		Capitulo cap = (Capitulo) o;
		return Objects.equals(numeroCapitulo, cap.numeroCapitulo) && Objects.equals(titulo, cap.titulo) 
				&& Objects.equals(descripcion, cap.descripcion) && Objects.equals(enlace, cap.enlace)
				&& Objects.equals(serie, cap.serie) && Objects.equals(temporada, cap.temporada);
	}
	
	public int getNumeroCapitulo() {
		return numeroCapitulo;
	}
	public void setNumeroCapitulo(int numeroCapitulo) {
		this.numeroCapitulo = numeroCapitulo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEnlace() {
		return enlace;
	}
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	public Temporada getTemporada() {
		return temporada;
	}
	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}

	public Long getId() {
		return id;
	}
}
