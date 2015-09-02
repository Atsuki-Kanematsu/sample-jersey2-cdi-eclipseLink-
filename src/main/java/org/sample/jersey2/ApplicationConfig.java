package org.sample.jersey2;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.validation.ValidationFeature;

@ApplicationPath("/jer2")
public class ApplicationConfig extends ResourceConfig {

	public ApplicationConfig() {
		register(ValidationFeature.class);
		packages(this.getClass().getPackage().getName());
	}
}
