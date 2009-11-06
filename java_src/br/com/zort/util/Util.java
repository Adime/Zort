package br.com.zort.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Util implements ApplicationContextAware
{
	private static ApplicationContext	context	= null;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		Util.context = applicationContext;
	}

	public static Object getBean(String beanName)
	{

		if (context == null)
			context = ContextManager.getContext();

		return context.getBean(beanName);
	}

	public static String generateUUID()
	{
		long mostSignificantBits = UUID.randomUUID().getMostSignificantBits();
		if (mostSignificantBits < 0)
			mostSignificantBits *= -1;

		String id = String.valueOf(mostSignificantBits);
		id = id.substring(0, 10);
		String code = "";
		// adiciona "." a cada 3 dígitos
		int length = id.length();
		for (int i = 1; i < length; i++)
		{
			code += id.charAt(i - 1);
			if (i % 3 == 0 && i > 0 && i < length - 1)
				code += ".";
		}
		return code;
	}

	public static Object getId(Object value)
	{
		if (value == null)
			return null;

		Field field;
		try
		{
			field = value.getClass().getDeclaredField("id");
			field.setAccessible(true);
			return field.get(value);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	public static List<Object> getIds(List<? extends Object> data)
	{
		if (data == null || data.isEmpty())
			return new ArrayList<Object>();
		try
		{
			Field field = data.get(0).getClass().getDeclaredField("id");
			field.setAccessible(true);
			List<Object> ids = new ArrayList<Object>(data.size());
			for (Object object : data)
				ids.add(field.get(object));

			return ids;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}
}
