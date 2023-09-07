package com.administracion;

import DAO.*;
import modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import modelo.Edificio;
import modelo.Unidad;
import modelo.Persona;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EntityScan("entity")
@EnableJpaRepositories("DAO")
@ComponentScan("DAO")
public class TpApiApplication implements CommandLineRunner{

	@Autowired
	PersonaDAO personaDAO;

	@Autowired
	InquilinoDAO inquilinoDAO;

	@Autowired
	UnidadDAO unidadDAO;

	@Autowired
	EdificioDAO edificioDAO;



	public static void main(String[] args) {
		SpringApplication.run(TpApiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

//		Edificio e = edificioDAO.toNegocio(edificioDAO.ObtenerEdificioEntityCodigo(1));
//		System.out.println(e.toView().toString());
//		System.out.println(unidadDAO.obtenerUnidadByIdentificador(1).toView().toString());

		//System.out.println(personaDAO.obtenerPorDocumento("CI 13230978").toView().toString());

		List<Persona> personas = new ArrayList<>();
		personas = inquilinoDAO.obtenerTodosInquilinos();
		for (Persona p: personas){
			System.out.println(p.getDocumento());
		}



		//Unidad unidad = unidadDAO.toNegocio(unidadDAO.obtenerUnidadByIdentificador(1));

	}

}


