package in.nit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import in.nit.model.ShipmentType;



@Configuration
@EnableTransactionManagement
@EnableWebMvc
@PropertySource("classpath:application.properties")
@ComponentScan("in.nit")
public class AppConfig {
	@Autowired
  Environment env;
	
	@Bean
	public DataSource ds() {
	BasicDataSource d=new BasicDataSource();
	d.setDriverClassName(env.getProperty("db.driver"));
	d.setUrl(env.getProperty("db.url"));
	d.setUsername(env.getProperty("db.user"));
	d.setPassword(env.getProperty("db.pwd"));
	return d;
	}
	@Bean
	public LocalSessionFactoryBean sf() {
		LocalSessionFactoryBean bean=new LocalSessionFactoryBean();
		bean.setDataSource(ds());
		bean.setHibernateProperties(props());
		bean.setPackagesToScan("in.nit.model");
		//bean.setAnnotatedClasses(ShipmentType.class);
		return bean;
	}
	@Bean
	public Properties props() {
		Properties prop=new Properties();
		prop.put("hibernate.dialect",env.getProperty("hibernate.dialect"));
		prop.put("hibernate.show_sql", env.getProperty("hibernate.showsql"));
		prop.put("hibernate.format_sql", env.getProperty("hibernate.fmtsql"));
		prop.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		return prop;
	}
	@Bean
	public HibernateTemplate ht() {
		HibernateTemplate h=new HibernateTemplate();
		h.setSessionFactory(sf().getObject());
		return h;
	}
	@Bean
	public HibernateTransactionManager htm() {
		HibernateTransactionManager manager=new HibernateTransactionManager();
		manager.setSessionFactory(sf().getObject());
		return manager;
	}
	@Bean
	public InternalResourceViewResolver irvr() {
		InternalResourceViewResolver iv=new InternalResourceViewResolver();
		iv.setPrefix(env.getProperty("mvc.prefix"));
		iv.setSuffix(env.getProperty("mvc.suffix"));
		return iv;
	}
	//Commons Multipart
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}

}
