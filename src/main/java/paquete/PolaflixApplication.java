package paquete;

import java.util.List;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import entidadesDominio.Usuario;
import repositorios.UsuarioRepository;

@SpringBootApplication
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
