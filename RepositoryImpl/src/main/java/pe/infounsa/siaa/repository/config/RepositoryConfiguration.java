/**
 * 
 */
package pe.infounsa.siaa.repository.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * @author Siaa
 *
 */
@Configuration
@PropertySource({ "classpath:persistence.properties" })
@EnableJpaRepositories("pe.infounsa.siaa.repository")
@EnableTransactionManagement
@ComponentScan(value = { "pe.infounsa.siaa.repository.persistence.impl" })
public class RepositoryConfiguration {

	@Autowired
	private Environment env;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { "pe.infounsa.siaa.domain.persistence" });

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		vendorAdapter.setGenerateDdl(false);// true
		vendorAdapter.setDatabase(Database.POSTGRESQL);
		vendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgresPlusDialect");

		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());

		return em;
	}

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		// env.getProperty(CONNECT_URL)
		HikariConfig config = new HikariConfig();

		config.setDriverClassName("org.postgresql.Driver");

		config.setJdbcUrl(env.getProperty("jdbc.url"));
		                   
		config.setConnectionTestQuery("SELECT 1");

		// config.setPoolName("springHikariCP");
		config.setMaximumPoolSize(50);
		config.setMaxLifetime(30000);
		config.setIdleTimeout(30000);
		// config.setMinimumIdle(20);
		
		config.addDataSourceProperty("url", env.getProperty("jdbc.url"));
		config.addDataSourceProperty("user", env.getProperty("jdbc.user"));
		config.addDataSourceProperty("password",
				env.getProperty("jdbc.password"));

		config.addDataSourceProperty("cachePrepStmts",
				env.getProperty("jdbc.pool.cachePrepStmts"));
		config.addDataSourceProperty("prepStmtCacheSize",
				env.getProperty("jdbc.pool.prepStmtCacheSize"));
		config.addDataSourceProperty("prepStmtCacheSqlLimit",
				env.getProperty("jdbc.pool.prepStmtCacheSqlLimit"));
		config.addDataSourceProperty("useServerPrepStmts",
				env.getProperty("jdbc.pool.useServerPrepStmts"));
		/**/
		
		HikariDataSource dataSource = new HikariDataSource(config);

		return dataSource;
	}

	@Bean
	public PlatformTransactionManager transactionManager(
			EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}
	/**/

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties additionalProperties() {
		Properties properties = new Properties();
		
		properties.setProperty("hibernate.show_sql", "false");
		
		return properties;
	}
	
}
