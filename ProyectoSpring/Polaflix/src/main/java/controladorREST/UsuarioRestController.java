package controladorREST;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import entidadesDominio.UserNotFoundException;
import entidadesDominio.Usuario;
import repositorios.UsuarioRepository;

@RestController
@RequestMapping("/{nombreUsuario}")
public class UsuarioRestController{

	private final UsuarioRepository userRepository;

	@Autowired
	public UsuarioRestController(UsuarioRepository userRepository) {

		this.userRepository=userRepository;

	}

	@RequestMapping(method = RequestMethod.GET)
	Usuario muestraUsuario(@PathVariable String nombreUsuario) {
		this.validaUsuario(nombreUsuario);
		return this.userRepository.findById(nombreUsuario).get();//devuelve el usuario con el get(). El findById devuelte
		// un Optional<Usuario>. En Ecplise viene que es por 
		//si no existe y tal
	}

	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<?> add(@PathVariable String nombreUsuario, @RequestBody Usuario input) {
		
		Usuario resultado=userRepository.save(new Usuario(nombreUsuario,input.getContraseña(),input.getCuentaBancaria(),input.isCuotaFija()));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{nombreUsuario}").buildAndExpand(resultado.getNombreUsuario()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	void elimina(@PathVariable String nombreUsuario, @RequestBody Usuario input) {
		
		this.validaUsuario(nombreUsuario);
		userRepository.delete(input);	
	}
	
	
	private void validaUsuario(String nombreUser) {
		this.userRepository.findById(nombreUser).orElseThrow(
				() -> new UserNotFoundException(nombreUser));
	}

}
