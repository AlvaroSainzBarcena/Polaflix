package paquete;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SerieRepository extends CrudRepository<Serie, Long> {
	
	List<Serie> findByInicial(char inicial);

}
