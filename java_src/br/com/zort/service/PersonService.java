package br.com.zort.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zort.dao.PersonDAO;
import br.com.zort.model.Person;
import br.com.zort.service.interfaces.IPersonService;

@Service
public class PersonService implements IPersonService {

	@Autowired
	private PersonDAO personDAO;
	
	public List<Person> getAllPerson() {
		return personDAO.getAllPerson();
	}

	public Person getPersonById(Integer id) {
		return personDAO.getPersonById(id);
	}

}
