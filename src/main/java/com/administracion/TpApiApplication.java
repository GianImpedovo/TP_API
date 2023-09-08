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
	UnidadDAO unidadDAO;
//
	@Autowired
	EdificioDAO edificioDAO;


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

//		System.out.println(controlador.buscarUnidad(1,"2","2").toView().toString());

		List<UnidadEntity> unidades = edificioDAO.obtenerUnidadesEdificio(2);
//		List<Unidad> unidades = edificio.getUnidades();
//		System.out.println(edificio.toView().toString());
//		System.out.println(edificio.getUnidades().size());
		List<Unidad> uni = new ArrayList<>();
		for (UnidadEntity ue: unidades)
			uni.add(unidadDAO.toNegocio(ue));

		for (Unidad u: uni)
			System.out.println(u.toView().toString());



	}

}


