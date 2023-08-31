package com.administracion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import entity.EdificioEntity;
import modelo.Edificio;
import repositorios.EdificioRepository;

@SpringBootApplication
@EntityScan("entity")
@EnableJpaRepositories("repositorios")
public class TpApiApplication implements CommandLineRunner{
	
	@Autowired
	EdificioRepository edificioRepositorio;

	public static void main(String[] args) {
		SpringApplication.run(TpApiApplication.class, args);
	}
	

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("aaa");
		
		List<EdificioEntity> edificiosEntidad = edificioRepositorio.findAll();
		List<Edificio> edificios = new ArrayList<Edificio>();
		for(EdificioEntity e: edificiosEntidad)
			edificios.add(e.toNegocio());
		
		
		for(Edificio e: edificios)
			System.out.println(e.toView().toString());
		
		
		/*
		 * if(obtener.isPresent()) System.out.println(obtener.toString());
		 */
		
	}

}
