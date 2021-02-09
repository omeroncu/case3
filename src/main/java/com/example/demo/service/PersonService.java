package com.example.demo.service;

import com.example.demo.domain.Person;
import com.example.demo.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    List<PersonDTO> findAll();
     PersonDTO findById(Long id);
    PersonDTO create(PersonDTO personDTO);
    PersonDTO update(PersonDTO personDTO);
}
