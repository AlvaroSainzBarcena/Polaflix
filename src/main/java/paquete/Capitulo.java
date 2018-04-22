package paquete;

public class Capitulo {
	
	private int numeroCapitulo;
	private String titulo;
	private String descripcion;
	private String enlace;
	private Serie serie;
	private Temporada temporada;
	
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

}
