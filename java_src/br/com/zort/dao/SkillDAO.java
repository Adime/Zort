package br.com.zort.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.zort.model.Skill;

@Repository
public class SkillDAO extends BaseHibernateDAO<Skill> {
	
	@Autowired
	public SkillDAO(SessionFactory sessionFactory) {
		super(Skill.class);
		super.setSessionFactory(sessionFactory);
	}
	
	public void saveOrUpdate(Skill skill)
	{
		getHibernateTemplate().saveOrUpdate(skill);
	}
	public void saveOrUpdate(List<Skill> skills)
	{
		for (Skill s : skills)
			saveOrUpdate(s);
	}

}
