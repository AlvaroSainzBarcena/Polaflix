package controladorREST;

import java.net.URI;
import java.util.Set;
import java.util.SortedSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import entidadesDominio.Capitulo;
import entidadesDominio.Factura;
import entidadesDominio.Serie;
import entidadesDominio.UserNotFoundException;
import entidadesDominio.Usuario;
import repositorios.SerieRepository;
import repositorios.UsuarioRepository;

@RestController
@RequestMapping("/usuarios/{nombreUsuario}")
public class UsuarioRestController{

	private final UsuarioRepository userRepository;
	private final SerieRepository serieRepository;

	@Autowired
	public UsuarioRestController(UsuarioRepository userRepository, SerieRepository serieRepository) {

		this.userRepository=userRepository;
		this.serieRepository=serieRepository;

	}

	// Devuelve el usuario con el nombre especificado
	@RequestMapping(method = RequestMethod.GET)
	@CrossOrigin(origins = "http://localhost:8000")
	Usuario muestraUsuario(@PathVariable String nombreUsuario) {
		this.validaUsuario(nombreUsuario);
		return this.userRepository.findById(nombreUsuario).get();//devuelve el usuario con el get(). El findById devuelte
		// un Optional<Usuario>. En Ecplise viene que es por 
		//si no existe y tal
	}

	// Anhade el usuario a la base de datos con el nombre especificado
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@PathVariable String nombreUsuario, @RequestBody Usuario input) {

		Usuario resultado=userRepository.save(new Usuario(nombreUsuario,input.getContraseña(),input.getCuentaBancaria(),input.isCuotaFija()));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/usuarios/{nombreUsuario}").buildAndExpand(resultado.getNombreUsuario()).toUri();
		return ResponseEntity.created(location).build();

	}

	// Elimina el usuario de la base de datos con el nombre especificado
	@RequestMapping(method = RequestMethod.DELETE)
	void elimina(@PathVariable String nombreUsuario, @RequestBody Usuario input) {

		this.validaUsuario(nombreUsuario);
		userRepository.delete(input);	
	}

	// Comprueba que el nombre del usuario existe en la base de datos. Si no existe, lanza excepcion
	private void validaUsuario(String nombreUser) {
		this.userRepository.findById(nombreUser).orElseThrow(
				() -> new UserNotFoundException(nombreUser));
	}

	// Devuelve la lista de series pendientes del usuario
	@RequestMapping(value="seriesPendientes", method = RequestMethod.GET)
	Set<Serie> muestraPendientes(@PathVariable String nombreUsuario) {
		this.validaUsuario(nombreUsuario);

		Usuario u=userRepository.findById(nombreUsuario).get();
		return u.getSeriesPendientes();
	}

	// Anhade una serie pendiente al usuario
	@RequestMapping(value="seriesPendientes/{idSerie}", method = RequestMethod.POST)
	public Usuario anhadePendiente(@PathVariable String nombreUsuario, @PathVariable long idSerie) {
		this.validaUsuario(nombreUsuario);

		Serie s=serieRepository.findById(idSerie).get();
		Usuario u= userRepository.findById(nombreUsuario).get();

		boolean anhadida=u.nuevaSeriePendiente(s);

		if(anhadida== false) {
			return null;
		}

		return userRepository.save(u);

	}

	// Devuelve la lista de series empezadas del usuario
	@RequestMapping(value="seriesEmpezadas", method = RequestMethod.GET)
	Set<Serie> muestraEmpezadas(@PathVariable String nombreUsuario) {
		this.validaUsuario(nombreUsuario);

		Usuario u=userRepository.findById(nombreUsuario).get();
		return u.getSeriesEmpezadas();
	}

	// Anhade una serie empezada al usuario
	@RequestMapping(value="seriesEmpezadas/{idSerie}", method = RequestMethod.POST)
	public Usuario anhadeEmpezada(@PathVariable String nombreUsuario, @PathVariable long idSerie) {
		this.validaUsuario(nombreUsuario);

		Serie s=serieRepository.findById(idSerie).get();
		Usuario u= userRepository.findById(nombreUsuario).get();

		boolean anhadida=u.nuevaSerieEmpezada(s);

		if(anhadida== false) {
			return null;
		}

		return userRepository.save(u);

	}

	// Devuelve la lista de series terminadas del usuario
	@RequestMapping(value="seriesTerminadas", method = RequestMethod.GET)
	Set<Serie> muestraTerminadas(@PathVariable String nombreUsuario) {
		this.validaUsuario(nombreUsuario);

		Usuario u=userRepository.findById(nombreUsuario).get();
		return u.getSeriesTerminadas();
	}
	
	// Anhade una serie terminada al usuario
	@RequestMapping(value="seriesTerminadas/{idSerie}", method = RequestMethod.POST)
	public Usuario anhadeTerminada(@PathVariable String nombreUsuario, @PathVariable long idSerie) {
		this.validaUsuario(nombreUsuario);

		Serie s=serieRepository.findById(idSerie).get();
		Usuario u= userRepository.findById(nombreUsuario).get();

		boolean anhadida=u.nuevaSerieTerminada(s);

		if(anhadida== false) {
			return null;
		}

		return userRepository.save(u);
	}
	
	// Devuelve la factura del usuario en funcion de la fecha especificada
	@RequestMapping(value="facturas/{anio}/{mes}", method = RequestMethod.GET)
	public Factura muestraFactura(@PathVariable String nombreUsuario, @PathVariable int anio, @PathVariable int mes) {
		this.validaUsuario(nombreUsuario);
		Usuario u= userRepository.findById(nombreUsuario).get();
		
		return u.muestraFacturaPorFecha(anio, mes); // si no la encuentra, devuelve null
			
	}
	
	// Se ejecuta cuando un usuario visualiza un capitulo
	@RequestMapping(value="/series/{idSerie}/temporadas/{numTemp}/visualizarCapitulo/{numCap}", method = RequestMethod.POST)
	public boolean verCapitulo(@PathVariable String nombreUsuario, @PathVariable long idSerie, 
			@PathVariable int numTemp, @PathVariable int numCap) {
		
		Usuario u = userRepository.findById(nombreUsuario).get();
		Serie s=serieRepository.findById(idSerie).get();
		
		Capitulo cap = s.getTemporadaById(numTemp).getCapByNumCap(numCap); //busca el capitulo indicado para visualizar
		
		if(cap==null) { // no existe el capitulo
			return false;
		}
		
		u.nuevoCapiVisualizado(cap); 
		userRepository.save(u);
		return true;
	}
	

}
