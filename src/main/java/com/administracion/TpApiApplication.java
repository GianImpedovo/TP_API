package com.administracion;

import DAO.*;
import controlador.Controlador;
import entity.DuenioEntity;
import entity.EdificioEntity;
import entity.PersonaEntity;
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

	@Autowired
	Controlador controlador;

	@Autowired
	UnidadDAO unidadDAO;
	public static void main(String[] args) {
		SpringApplication.run(TpApiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		List<EdificioView> edificios = controlador.getEdificios();
//		for (EdificioView e: edificios)
//			System.out.println(e.toString());

//		List<PersonaView> unidadesView = controlador.dueniosPorUnidad(1, "70", "23");
//		//System.out.println(unidadesView.size());
//		for (PersonaView u: unidadesView)
//			System.out.println(u.toString());
//
// 		"DNI555555555"

// 		controlador.transferirUnidad(1, "70", "23", "DNI555555555");
		controlador.agregarDuenioUnidad(1, "70", "23", "DNI44444444");
//		List<Persona> duenios = unidad.getDuenios();
//		for (Persona d: duenios)
//			System.out.println(d.toView().toString());
//		unidadDAO.eliminarDuenios(unidad);
//		Persona persona = controlador.buscarPersona("DNI555555555");
//		unidadDAO.agregarDuenio();

//		controlador.eliminarPersona("DNI41200440");

	}

}


