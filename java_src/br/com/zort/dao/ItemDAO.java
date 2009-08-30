package br.com.zort.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.zort.model.Item;
import br.com.zort.model.User;

@Repository
public class ItemDAO extends BaseHibernateDAO<Item> {
	
	@Autowired
	public ItemDAO(SessionFactory sessionFactory) {
		super(Item.class);
		super.setSessionFactory(sessionFactory);
	}
	
	public void saveOrUpdate(Item item)
	{
		getHibernateTemplate().saveOrUpdate(item);
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> getStoreItems()
	{
		DetachedCriteria dc = DetachedCriteria.forClass(Item.class);
		dc.add(Restrictions.isNull("user"));
		
		return (List<Item>) getHibernateTemplate().findByCriteria(dc);
	}
	
	@SuppressWarnings("unchecked")
	public List<Item> getItemByUser(User u)
	{
		DetachedCriteria dc = DetachedCriteria.forClass(Item.class);
		dc.add(Restrictions.eq("user", u));
		
		return (List<Item>) getHibernateTemplate().findByCriteria(dc); 
	}
	public void updateItem(Item i)
	{
		getHibernateTemplate().saveOrUpdate(i);
	}
}
