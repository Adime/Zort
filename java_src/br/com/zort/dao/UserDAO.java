package br.com.zort.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import br.com.zort.model.User;

@Repository
public class UserDAO extends BaseHibernateDAO<User> {

	@Autowired
	public UserDAO(SessionFactory sessionFactory) {
		super(User.class);
		super.setSessionFactory(sessionFactory);
	}
	
	public User addOrUpdate(User user)
	{
		getHibernateTemplate().saveOrUpdate(user);
		return user;
	}
	public User getUserByLoginAndPass(String login, String pass)
	{
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("login", login));
		dc.add(Restrictions.eq("password", pass));
		
		User u = (User) DataAccessUtils.uniqueResult(getHibernateTemplate().findByCriteria(dc));
		
		return u;
	}
}
