package pe.infounsa.siaa.rest.services.seguridad.cors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

@Component
public class SimpleCORSFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	    HttpServletResponse response = (HttpServletResponse) res;
	    HttpServletRequest request = (HttpServletRequest) req;
	    response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
	    response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,Origin,Content-Type, Accept, X-Auth-Token");
	    response.setHeader("Access-Control-Expose-Headers", "X-Auth-Token");
	    response.setHeader("Access-Control-Max-Age", "3600");
	    if (request.getMethod()!="OPTIONS") {
	      chain.doFilter(req, res);
	    } else {
	    }
	  }

	public void init(FilterConfig filterConfig) {}

	public void destroy() {}

	}

