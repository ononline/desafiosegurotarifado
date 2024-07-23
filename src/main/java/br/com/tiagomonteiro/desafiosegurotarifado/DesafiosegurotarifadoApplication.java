package br.com.tiagomonteiro.desafiosegurotarifado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories("br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.persistence")
//@EntityScan("br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.persistence")
//@ComponentScan("br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.controllers")
//@ComponentScan("br.com.tiagomonteiro.desafiosegurotarifado.main")
public class DesafiosegurotarifadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafiosegurotarifadoApplication.class, args);
	}

}
