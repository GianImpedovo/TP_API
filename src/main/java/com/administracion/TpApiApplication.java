package com.administracion;

import DAO.*;
import controlador.Controlador;
import entity.DuenioEntity;
import modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import modelo.Edificio;
import vista.EdificioView;
import vista.UnidadView;

import java.util.List;


@SpringBootApplication
@EntityScan("entity")
@EnableJpaRepositories("DAO")
@ComponentScan(basePackages = {"DAO", "entity", "controlador"})
public class TpApiApplication implements CommandLineRunner{

	@Autowired
	Controlador controlador;

	public static void main(String[] args) {
		SpringApplication.run(TpApiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

//		List<EdificioView> edificios = controlador.getEdificios();
//		for (EdificioView e: edificios)
//			System.out.println(e.toString());

//		List<UnidadView> unidades = controlador.getUnidadesPorEdificio(2);
//		for (UnidadView u: unidades)
//			System.out.println(u.toString());

		System.out.println(controlador.buscarUnidad(1,"2","2").toView().toString());
	}

}


