package com.joao.cursospring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CursoSpringApplication {

	// @Autowired   //injecao
	// @Qualifier("applicationName")  //identificar o bean pelo nome
	// private String applicationName;

	@Value("${application.name}")
	private String applicationName;

	// @Bean
    // public CommandLineRunner commandLineRunner(@Autowired Clientes clientes){
    //     return args -> {
    //         Cliente c = new Cliente("Fulano");
    //         clientes.save(c);
    //     };
    // }

	@GetMapping("/")
	public String helloWorld(){
		return applicationName;
	}

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}
}
