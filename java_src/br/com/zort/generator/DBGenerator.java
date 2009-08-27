package br.com.zort.generator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.regex.Pattern;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.com.zort.hibernate.AnnotationSessionFactoryBean;

public class DBGenerator {

		private static boolean	doDebug	= true;

		public static void main(String[] args) throws Exception
		{
			if (args != null && args.length > 0)
			{
				doDebug = Boolean.valueOf(args[0]);
			}

			debug("Starting...");
			debug("--> Creating schema...");
			AnnotationConfiguration configuration = new AnnotationConfiguration();

			configuration.configure("/conf/hibernate.cfg.xml");

			new AnnotationSessionFactoryBean().doPostProcessConfiguration(configuration);

			SchemaExport se = new SchemaExport(configuration);
			se.create(true, true);

			debug("--> Schema created.");

			if (doDebug == true)
			{
				System.exit(0);
			}

		}

		private static void debug(String message)
		{
			if (doDebug == true)
			{
				System.out.println(message);
			}
		}
	}