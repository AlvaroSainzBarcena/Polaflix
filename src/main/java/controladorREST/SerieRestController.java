package controladorREST;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import entidadesDominio.Capitulo;
import entidadesDominio.Serie;
import repositorios.SerieRepository;


@RestController
@RequestMapping("/series")
public class SerieRestController {

	private final SerieRepository serieRepo;
	
	@Autowired
	public SerieRestController(SerieRepository serieRepo) {
		
		this.serieRepo=serieRepo;
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	Iterable<Serie> muestraSeries() {
		
		return this.serieRepo.findAll();
	}
	
	@RequestMapping(value="/series/{idSerie}/temporada/{idTemporada}", method=RequestMethod.GET)
	public Set<Capitulo> capitulosPorTemporada(@PathVariable long idSerie, @PathVariable int idTemporada){
		
		Serie s=serieRepo.findById(idSerie).get();
		
		return s.getTemporadaById(idTemporada).getCapitulos();
		
	}

}
