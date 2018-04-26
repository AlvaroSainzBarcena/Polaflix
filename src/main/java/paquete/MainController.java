package paquete;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller    // This means that this class is a Controller

public class MainController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private SerieRepository serieRepository;

	public  String addNewSerie (Categoria categoria, String nombreSerie, Set<Creador> creadores,
			Set<Temporada> temporadas, Set<Actor> actoresPrincipales, Set<Capitulo> capitulos) {

		Serie serie = new Serie(categoria,nombreSerie,creadores,temporadas,actoresPrincipales,capitulos);
		serieRepository.save(serie);
		return "Saved";
	}

	public Iterable<Serie> getAllSeries() {
		// This returns a JSON or XML with the series
		return serieRepository.findAll();
	}
	public List<Serie>getSerieByInicial(char ini){
		return serieRepository.findByInicial(ini);
	}
}