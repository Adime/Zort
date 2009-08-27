package br.com.zort.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.com.zort.dao.interfaces.IBaseHibernateDAO;

public class BaseHibernateDAO< T > extends HibernateDaoSupport implements IBaseHibernateDAO< T > {

	private Class< T > klass;
	
	public BaseHibernateDAO( Class< T > klass ) {
		this.klass = klass;
	}

	@SuppressWarnings("unchecked")
	public T load( Serializable id ) {

		T load = (T) this.getHibernateTemplate().load( klass, id );
		return load;
	}

	public Object save( T o ) {

		return this.getHibernateTemplate().save( o );
	}

	public T update( T o ) {

		this.getHibernateTemplate().update( o );
		return o;
	}

	public void delete( T o ) {

		this.getHibernateTemplate().delete( o );
	}

	public void refresh( T o ) {

		this.getHibernateTemplate().refresh( o );
	}

	public void refreshDerivated( Object o ) {

		this.getHibernateTemplate().refresh( o );
	}

	@SuppressWarnings("unchecked")
	public List< T > findByProperty( String propertyName, Object value ) {

		return getHibernateTemplate().findByCriteria( DetachedCriteria.forClass( klass ).add( Restrictions.eq( propertyName, value ) ) );
	}

	@SuppressWarnings("unchecked")
	public List< T > listAll() {

		return getHibernateTemplate().findByCriteria( DetachedCriteria.forClass( klass ) );
	}

	@SuppressWarnings("unchecked")
	public < E > List< E > listAll( Class< E > anotherClass ) {

		return getHibernateTemplate().findByCriteria( DetachedCriteria.forClass( anotherClass ) );
	}

	public long count() {

		DetachedCriteria criteria = DetachedCriteria.forClass( klass );
		criteria.setProjection( Projections.rowCount() );

		long count = (Integer) getHibernateTemplate().findByCriteria( criteria ).get( 0 );
		return count;
	}

	public void saveBatch( final List< T > list ) {

		saveDerivatedBatch( list );
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public void saveDerivatedBatch( final List list ) {

		// this.getHibernateTemplate().saveOrUpdateAll( list );
		if ( list != null && list.isEmpty() == false )
			getHibernateTemplate().execute( new HibernateCallback() {

				public Object doInHibernate( Session session ) throws HibernateException {

					int count = 0;
					for ( Object object : list ) {
						session.saveOrUpdate( object );
						if ( ++count % 20 == 0 ) {
							session.flush();
							session.clear();
						}

					}
					return null;
				}
			}, true );
	}

	public Object saveDependency( Object o ) {

		return this.getHibernateTemplate().save( o );
	}

	@SuppressWarnings("unchecked")
	public T getById( Integer id ) {

		return (T) getHibernateTemplate().get( klass, id );
	}

}
