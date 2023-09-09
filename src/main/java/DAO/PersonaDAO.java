package DAO;

import entity.PersonaEntity;
import modelo.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PersonaDAO{

    @Autowired
    PersonaRepository personaRepository;

    public PersonaDAO(){}

}
