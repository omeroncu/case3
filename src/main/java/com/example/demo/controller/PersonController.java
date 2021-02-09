package com.example.demo.controller;


import com.example.demo.controller.constants.ApiEndpoints;
import com.example.demo.dto.PersonDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.PersonService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = ApiEndpoints.PERSON_API_BASE_URL, produces = ApiEndpoints.RESPONSE_CONTENTTYPE)
public class PersonController {

    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<PersonDTO>> getPersons() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }
    @PostMapping(value= "/create")
    public ResponseEntity<PersonDTO> create(@RequestBody @Valid PersonDTO personDTO) {
        return new ResponseEntity<>(personService.create(personDTO), HttpStatus.OK);
    }
    @PostMapping(value="/update")
    public ResponseEntity<PersonDTO> update(@RequestBody @Valid PersonDTO personDTO) {
        return new ResponseEntity<>(personService.update(personDTO), HttpStatus.OK);
    }

    @GetMapping(value="/findById/{id}")
    public ResponseEntity<PersonDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }
}
