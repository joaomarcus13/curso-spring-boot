package com.joao.cursospring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;



@Development
public class ConfigurationApp {

    // @Bean(name="applicationName")  //vai ser inserido no container de injecao 
    // public String applicationName(){
    //     return "Sistema de Vendas";
    // }

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("rodando a configuracao de desenvolvimento");

        };
    }

}
