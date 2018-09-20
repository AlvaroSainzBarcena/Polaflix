package controladorREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import entidadesDominio.Serie;
import entidadesDominio.Temporada;
import repositorios.SerieRepository;


@RestController
@RequestMapping("/series")
public class SerieRestController {

	private final SerieRepository serieRepo;
	
	@Autowired
	public SerieRestController(SerieRepository serieRepo) {
		
		this.serieRepo=serieRepo;
		
	}
	
	// Devuelve todas las series de la plataforma
	@RequestMapping(method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:8000")
	Iterable<Serie> muestraSeries() {
		
		return this.serieRepo.findAll();
	}
	
	// Devuelve la lista de series que empiecen con la inicial especificada
	@RequestMapping(value="/inicial/{inicial}", method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:8000")
	Iterable<Serie> muestraSeriesPorInicial(@PathVariable char inicial) {
		
		return this.serieRepo.findByInicial(inicial);
	}
	
	// Devuelve la serie con el id especificado
	@RequestMapping(value="/{idSerie}", method=RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:8000")
	public Serie serie(@PathVariable long idSerie){
		
		return serieRepo.findById(idSerie).get();
		
	}

	// Devuelve la temporada especificada de la serie especificada
	@RequestMapping(value="/{idSerie}/temporada/{idTemporada}", method=RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:8000")
	public Temporada capitulosPorTemporada(@PathVariable long idSerie, @PathVariable int idTemporada){
		
		Serie s=serieRepo.findById(idSerie).get();
		
		return s.getTemporadaById(idTemporada);
		
	}
	
}
