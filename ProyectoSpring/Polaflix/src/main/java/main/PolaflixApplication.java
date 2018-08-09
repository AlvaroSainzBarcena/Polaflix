package main;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import entidadesDominio.Usuario;
import repositorios.UsuarioRepository;

@SpringBootApplication
@ComponentScan({"controladorREST"})
@EntityScan("entidadesDominio")
@EnableJpaRepositories("repositorios")
public class PolaflixApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolaflixApplication.class, args);
	}
	// Para probar, lo ejecuta al principio

	@Bean
	CommandLineRunner init(UsuarioRepository userRepo) {
		return (evt) -> Arrays.asList(
				"userTest1,userTest2".split(","))
				.forEach(
						a -> {
							userRepo.save(new Usuario(a,
									"passwordTest","cuentaBacnariaTest",true));
							
						});
	}

	/**
	@Bean
	CommandLineRunner runner(){
		return args -> {
			System.out.println("CommandLineRunner running in the UnsplashApplication class...");
			//SerieRepository repo = null;
			//List series=repo.findByInicial('b');
			//System.out.println(series.size());
		};
	}*/
}
