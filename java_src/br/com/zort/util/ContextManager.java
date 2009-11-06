package br.com.zort.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.SessionScope;

public class ContextManager extends AbstractDependencyInjectionSpringContextTests
{
	protected ServletRequestAttributes	attributes;

	public ContextManager()
	{
		super();
		setAutowireMode(AUTOWIRE_BY_NAME);
	}

	@Override
	protected String[] getConfigLocations()
	{
		return new String[]
		{ "/conf/applicationContext.xml"};
	}

	protected void setUpRequest(ConfigurableApplicationContext context)
	{
		super.applicationContext = context;

		context.getBeanFactory().registerScope("session", new SessionScope());
		MockHttpServletRequest request = new MockHttpServletRequest();
		attributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(attributes);
	}

	@Override
	protected void prepareTestInstance() throws Exception
	{
		setUpRequest(applicationContext);
		super.prepareTestInstance();
	}

	// utilizado por outras classes de testes e scraps
	public static ApplicationContext getContext()
	{
		try
		{
			ContextManager session = new ContextManager();
			session.setUp();
			session.prepareTestInstance();

			return session.applicationContext;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
}