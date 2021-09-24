package example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.cfg.AvailableSettings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@SpringBootApplication
public class Application
{
	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}
	
	@Configuration
	@EnableJpaRepositories
	public static class ServerConfiguration
	{
		private EntityManagerFactory emf;
		
		@Bean
		public EntityManagerFactory entityManagerFactory()
		{
			if (emf == null)
			{
				Map<String, Object> properties = new HashMap<>();
				properties.put(AvailableSettings.CLASSLOADERS, Collections.singleton(Thread.currentThread().getContextClassLoader()));
				emf =  Persistence.createEntityManagerFactory("test", properties);
			}
			return emf;
		}

		@Bean
		public PlatformTransactionManager transactionManager()
		{
			 JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory());
		     return transactionManager;
		}
		
		@Bean
		public ShallowEtagHeaderFilter shallowEtagHeaderFilter() 
		{
		    return new ShallowEtagHeaderFilter();
		}
	}
}
