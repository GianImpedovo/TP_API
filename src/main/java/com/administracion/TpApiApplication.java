package com.administracion;

import DAO.*;
import controlador.Controlador;
import entity.DuenioEntity;
import entity.EdificioEntity;
import entity.UnidadEntity;
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
import vista.PersonaView;
import vista.UnidadView;

import java.util.ArrayList;
import java.util.List;
import modelo.Unidad;

@SpringBootApplication
@EntityScan("entity")
@EnableJpaRepositories("DAO")
@ComponentScan(basePackages = {"DAO", "entity", "controlador"})
public class TpApiApplication implements CommandLineRunner{

//	@Autowired
//	UnidadDAO unidadDAO;
//	@Autowired
//	EdificioDAO edificioDAO;


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


//		List<PersonaView> vistas = controlador.habilitadosPorEdificio(1);
//		//System.out.println(vistas.size());
//		for (PersonaView u: vistas)
//			System.out.println(u.toString());

		List<PersonaView> unidad = controlador.inquilinosPorUnidad(1, "9", "4");
		for (PersonaView u: unidad)
			System.out.println(u.toString());
	}

}


