package DAO;

import entity.ReclamoEntity;
import modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import modelo.Reclamo;
@Repository
public class ReclamoDAO {

    @Autowired
    ReclamoRepository reclamoRepository;


    private ReclamoDAO reclamoDAO;

    public ReclamoDAO(){}


}
