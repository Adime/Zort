package br.com.zort.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.zort.model.Map;
import br.com.zort.model.Message;

@Repository
public class MessageDAO extends BaseHibernateDAO<Message> {

	
	@Autowired
	public MessageDAO(SessionFactory sessionFactory) {
		super(Message.class);
		super.setSessionFactory(sessionFactory);
	}
	
	public void addOrUpdate(Message message)
	{
		getHibernateTemplate().saveOrUpdate(message);
	}
	
	public List<Message> getMessagesByUserName(String userName)
	{
		DetachedCriteria dc = DetachedCriteria.forClass(Message.class);
		dc.add(Restrictions.eq("dest", userName));
		
		List<Message> m = (List<Message>) getHibernateTemplate().findByCriteria(dc,0,1);
		
		return m;
		
	}
	
	public void delete(Message m)
	{
		getHibernateTemplate().delete(m);
	}
}
