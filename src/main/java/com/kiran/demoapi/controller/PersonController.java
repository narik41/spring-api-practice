package com.kiran.demoapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiran.demoapi.model.Person;
import com.kiran.demoapi.service.PersonService;
 
@RequestMapping("api/v1/person")
@RestController
public class PersonController {

	@Autowired
	private PersonService personService ; 
	
	@PostMapping
	public void addPerson(@Valid @NonNull @RequestBody Person person) {
		personService.addPerson(person);
	}
	
	@GetMapping
	public List<Person> getAllPeople(){
		return personService.getAllPeople();
	}
	
	@GetMapping(path="/{id}")
	public Optional<Person> getPersonById(@PathVariable("id") Integer id){
		return Optional.ofNullable(personService.getPersonById(id)
					.orElse(null));
	}
	
	@DeleteMapping(path="/{id}")
	public void deletePersonById(@PathVariable("id") Integer id) {
		personService.deletePersonById(id);
	}
	
	@PutMapping(path= "{id}")
	public void update(@PathVariable("id")Integer id, @Valid @NonNull @RequestBody Person person) {
		personService.updatePersonById(id, person);
	}
}
