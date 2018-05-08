package paquete;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		
		return this.userRepository.findById(nombreUsuario).get();//devuelve el usuario con el get(). El findById devuelte
																// un Optional<Usuario>. En Ecplise viene que es por 
																//si no existe y tal
	}
	

}
