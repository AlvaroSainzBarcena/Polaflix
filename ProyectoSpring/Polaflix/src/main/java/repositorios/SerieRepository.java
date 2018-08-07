package repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import entidadesDominio.Serie;

public interface SerieRepository extends CrudRepository<Serie, Long> {
	
	List<Serie> findByInicial(char inicial);

}
