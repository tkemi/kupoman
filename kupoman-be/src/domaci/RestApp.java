package domaci;

import javax.ws.rs.ApplicationPath;

import domaci.filters.CorsFilter;
import org.glassfish.jersey.server.ResourceConfig;


@ApplicationPath("/rest")
public class RestApp extends ResourceConfig{

	public RestApp() {
		packages("domaci");
		register(CorsFilter.class);
	}
	
}