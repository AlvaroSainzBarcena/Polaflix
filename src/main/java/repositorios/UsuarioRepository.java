package repositorios;

import org.springframework.data.repository.CrudRepository;

import entidadesDominio.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{

	
}
