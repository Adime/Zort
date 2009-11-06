package br.com.zort.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import br.com.zort.model.Map;

@Repository
public class MapDAO extends BaseHibernateDAO<Map> {

	@Autowired
	public MapDAO(SessionFactory sessionFactory) {
		super(Map.class);
		super.setSessionFactory(sessionFactory);
	}

	public void addOrUpdate(Map map) {
		getHibernateTemplate().saveOrUpdate(map);
	}

	public Map getMapById(Integer id) {
		DetachedCriteria dc = DetachedCriteria.forClass(Map.class);
		dc.add(Restrictions.eq("id", id));
		Map m = (Map) DataAccessUtils.uniqueResult(getHibernateTemplate()
				.findByCriteria(dc));
		
		return m;
	}

}
