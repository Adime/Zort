package br.com.zort.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.zort.model.Tile;

@Repository
public class TileDAO extends BaseHibernateDAO<Tile> {

	@Autowired
	public TileDAO(SessionFactory sessionFactory) {
		super(Tile.class);
		super.setSessionFactory(sessionFactory);
	}
	@SuppressWarnings("unchecked")
	public List<Tile> getAllTiles() {
		DetachedCriteria dc = DetachedCriteria.forClass(Tile.class);
		return (List<Tile>) getHibernateTemplate().findByCriteria(dc);
	}
	
}
