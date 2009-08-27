package br.com.zort.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import br.com.zort.hibernate.AnnotationSessionFactoryBean;

public interface IBaseHibernateDAO< T > {

	T load( Serializable id );

	Object save( T o );

	T update( T o );

	void delete( T o );

	void refresh( T o );

	void refreshDerivated( Object o );

	List< T > findByProperty( String propertyName, Object value );

	List< T > listAll();

	< E > List< E > listAll( Class< E > anotherClass );

	long count();

	void saveBatch( final List< T > list );

	@SuppressWarnings("unchecked")
	void saveDerivatedBatch( final List list );

	Object saveDependency( Object o );

	T getById( Integer id );

}
