package com.example.demo.service.impl;

import com.example.demo.domain.Person;
import com.example.demo.dto.PersonDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;
    private final ModelMapper mapper;

    @Autowired
    public PersonServiceImpl(PersonRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PersonDTO> findAll() {
        return repository.findAll().stream().map(person -> mapper.map(person, PersonDTO.class)).collect(Collectors.toList());
    }

    @Override
    public PersonDTO findById(Long id) {
        Person person = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity Bulunamadı !"));
        return mapper.map(person, PersonDTO.class);
    }

    @Override
    public PersonDTO create(PersonDTO personDTO) {
        Person person = mapper.map(personDTO, Person.class);
        return mapper.map(repository.save(person), PersonDTO.class);

    }

    @Override
    public PersonDTO update(PersonDTO personDTO) {
        repository.findById(personDTO.getId()).orElseThrow(() -> new EntityNotFoundException("Entity Bulunamadı !"));
        Person newPerson = mapper.map(personDTO, Person.class);
        return mapper.map(repository.save(newPerson), PersonDTO.class);
    }
}
