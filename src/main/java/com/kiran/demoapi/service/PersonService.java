package com.kiran.demoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kiran.demoapi.dao.PersonDao;
import com.kiran.demoapi.model.Person;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao ; 
	
	public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
		this.personDao = personDao ; 
	}
	
	public int addPerson(Person person) {
		return personDao.insertPerson(person.getId(), person);
	}
	
	public List<Person> getAllPeople(){
		return personDao.selectAllPeople();
	}
	
	public Optional<Person> getPersonById(Integer id){
		return personDao.selectPersonById(id);
	}
	
	public int deletePersonById(Integer id ) {
		return personDao.deletePersonById(id);
	}
	
	public int updatePersonById(Integer id, Person person) {
		return personDao.updatePersonById(id, person);
	}
}
