package br.com.zort.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.zort.model.Robot;

@Repository
public class RobotDAO extends BaseHibernateDAO<Robot> {
	
	@Autowired
	public RobotDAO(SessionFactory sessionFactory) {
		super(Robot.class);
		super.setSessionFactory(sessionFactory);
	}
	
	public Robot saveOrUpdate(Robot robot)
	{
		getHibernateTemplate().saveOrUpdate(robot);
		return robot;
	}
}
