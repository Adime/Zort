package br.com.zort.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContextException;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;

import br.com.zort.model.Item;
import br.com.zort.model.Map;
import br.com.zort.model.Message;
import br.com.zort.model.Person;
import br.com.zort.model.Robot;
import br.com.zort.model.Skill;
import br.com.zort.model.Teleport;
import br.com.zort.model.MapTile;
import br.com.zort.model.Tile;
import br.com.zort.model.Type;
import br.com.zort.model.User;

/**
 * Utilizado pelo Spring, utiliza esta classe para configurações iniciais na
 * criação da SessionFactory do Hibernate.
 */
public class AnnotationSessionFactoryBean extends LocalSessionFactoryBean {

	// para facilitar os testes
	public void processConfig( Configuration configuration ) {

		postProcessConfiguration( configuration );
	}

	public void doPostProcessConfiguration( Configuration configuration ) throws HibernateException {

		postProcessConfiguration( configuration );
	}

	@Override
	protected SessionFactory newSessionFactory( Configuration config ) throws HibernateException {

		postProcessConfiguration( config );
		return config.buildSessionFactory();
	}

	@Override
	protected void postProcessConfiguration( Configuration configuration ) throws HibernateException {

		super.postProcessConfiguration( configuration );

		if ( !( configuration instanceof AnnotationConfiguration ) ) {
			throw new ApplicationContextException( "The configuration must be AnnotationConfiguration." );
		}

		AnnotationConfiguration conf = (AnnotationConfiguration) configuration;

		conf.addAnnotatedClass( Map.class );
		conf.addAnnotatedClass( MapTile.class );
		conf.addAnnotatedClass( Tile.class );
		conf.addAnnotatedClass( Teleport.class );
		conf.addAnnotatedClass( Person.class );
		conf.addAnnotatedClass( User.class );
		conf.addAnnotatedClass(Type.class);
		conf.addAnnotatedClass(Robot.class);
		conf.addAnnotatedClass(Skill.class);
		conf.addAnnotatedClass(Item.class);
		conf.addAnnotatedClass(Message.class);
	}
}
