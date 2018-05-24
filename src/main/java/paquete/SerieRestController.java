package paquete;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/series")
public class SerieRestController {

	private final SerieRepository serieRepo;
	
	@Autowired
	public SerieRestController(SerieRepository serieRepo) {
		
		this.serieRepo=serieRepo;
		
	}
	//TODO: NO HE PROBADO QUE ESTO FUNCIONE!!
	@RequestMapping(method = RequestMethod.GET)
	Iterable<Serie> muestraSeries() {
		
		return this.serieRepo.findAll();
	}

}
