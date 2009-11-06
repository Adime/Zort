package br.com.zort.service.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import br.com.zort.model.Person;

public interface IPersonService {
	
	@Transactional(readOnly = true)
	List<Person> getAllPerson();
	
	@Transactional(readOnly = true)
	Person getPersonById(Integer id);

}
