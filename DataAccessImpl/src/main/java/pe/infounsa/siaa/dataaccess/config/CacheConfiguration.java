/**
 * 
 */
package pe.infounsa.siaa.dataaccess.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @author Siaa
 *
 */
@Configuration
@EnableCaching
public class CacheConfiguration {
	
	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManagerFactoryBean().getObject());
	}
 
	@Bean
	public EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
		EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
//		cmfb.setCacheManagerName("cacheManager");
		cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
		cmfb.setShared(true);
		
		return cmfb;
	}

}
