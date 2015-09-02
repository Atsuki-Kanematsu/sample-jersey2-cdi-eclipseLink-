package org.sample.jersey2.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sample.jersey2.entity.User;
import org.sample.jersey2.service.UserService;

@Path("/jpa")
public class JPASampleAPI {

	@Inject
	protected UserService userService;

	@Path("getUsers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return userService.findAll();
	}

	@Path("getEnableUsers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getEnableUsers() {
		return userService.findEnableUsers();
	}
}
