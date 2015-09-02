package org.sample.jersey2.api;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sample.jersey2.bean.SessionBean;
import org.sample.jersey2.bean.SingletonBean;

@Path("/di")
public class DISampleAPI {

	@Inject
	protected HttpServletRequest request;

	@Inject
	protected SingletonBean sinBean;

	@Inject
	protected SessionBean sesBean;

	@Path("/getSessionId")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getSessionId() {
		return request.getSession().getId();
	}

	@Path("/setSingletonValue")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String setSingletonValue() {
		sinBean.setValue(request.getSession().getId());
		return "OK";
	}

	@Path("/getSingletonValue")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getSingletonValue() {
		return sinBean.getValue();
	}

	@Path("/setSessionValue")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String setSessionValue() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
		sesBean.setValue(sdf.format(new Date()));
		return "OK";
	}

	@Path("/getSessionValue")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getSessionValue() {
		return sesBean.getValue();
	}

}
