package com.kiran.demoapi.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.kiran.demoapi.model.Person;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
	
	private static List<Person> DB = new ArrayList<>();
	
	public int insertPerson(Integer id , Person person) {
		DB.add(new Person(id, person.getName()));
		return 1 ; 
	}

	@Override
	public List<Person> selectAllPeople() {
		return DB;
	}

	@Override
	public int deletePersonById(Integer id) {
		Optional<Person> personMayBe = selectPersonById(id);
		if(personMayBe.isEmpty())
			return 0 ;
		
		DB.remove(personMayBe.get());
		return 1; 
	}

	@Override
	public int updatePersonById(Integer id, Person updatePerson) {
		return selectPersonById(id)
					.map(person->{
						int indexOfPersonToDelet = DB.indexOf(person);
						if(indexOfPersonToDelet >= 0) {
							DB.set(indexOfPersonToDelet, new Person(id, updatePerson.getName()));
							return 1 ; 
						}
						return 0  ;
					})
					.orElse(0);
	}

	@Override
	public Optional<Person> selectPersonById(Integer id) {
		return DB.stream()
					.filter(person -> person.getId().equals(id))
					.findFirst(); 
	}
 
}
