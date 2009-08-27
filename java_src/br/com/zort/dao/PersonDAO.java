package br.com.zort.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import br.com.zort.model.Person;

@Repository
public class PersonDAO extends BaseHibernateDAO<Person> {

	@Autowired
	public PersonDAO(SessionFactory sessionFactory) {
		super(Person.class);
		super.setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> getAllPerson()
	{
		DetachedCriteria dc = DetachedCriteria.forClass(Person.class);
		List<Person> persons = (List<Person>) getHibernateTemplate().findByCriteria(dc); 
		return persons;
	}
	
	public Person getPersonById(Integer id)
	{
		DetachedCriteria dc = DetachedCriteria.forClass(Person.class);
		dc.add(Restrictions.eq("id", id));
		return (Person) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(dc));
	}

}
