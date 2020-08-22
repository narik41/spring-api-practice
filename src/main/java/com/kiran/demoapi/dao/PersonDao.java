package com.kiran.demoapi.dao;

import java.util.List;
import java.util.Optional;

import com.kiran.demoapi.model.Person;

public interface PersonDao {

	int insertPerson(Integer id, Person person);
	
	List<Person> selectAllPeople() ; 
	
	int deletePersonById(Integer id) ; 
	
	int updatePersonById(Integer id, Person person)  ; 
	
	Optional<Person> selectPersonById(Integer id);
}
