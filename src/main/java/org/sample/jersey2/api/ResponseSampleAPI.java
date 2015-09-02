package org.sample.jersey2.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.sample.jersey2.response.InvalidResponse;
import org.sample.jersey2.response.NotfoundResponse;
import org.sample.jersey2.response.ResponseBase;
import org.sample.jersey2.response.SampleChild;
import org.sample.jersey2.response.SampleParent;
import org.sample.jersey2.response.SuccessResponse;

@Path("/sample")
public class ResponseSampleAPI {

	@Path("/say")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String say() {
		return "Hello World!";
	}

	@Path("/getJsonObj")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SampleParent getJsonObj() {
		SampleParent parent = new SampleParent();
		List<SampleChild> children = new ArrayList<SampleChild>();
		for (int i = 0; i < 2; i++) {
			SampleChild child = new SampleChild();
			child.setField1("child-test");
			children.add(child);
		}
		parent.setChildren(children);
		return parent;
	}

	@Path("/getSuccessResponse")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBase getSuccessResponse() {
		return new SuccessResponse("OK", "success message");
	}

	@Path("/getNotfoundResponse")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBase getNotfoundResponse() {
		return new NotfoundResponse("data notfound message");
	}

	@Path("/getInvalidResponse")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBase getInvalidResponse() {
		Map<String, String> invalidFields = new HashMap<>();
		invalidFields.put("field1", "field1 is invalid");
		invalidFields.put("field2", "field2 is invalid");
		invalidFields.put("field3", "field3 is invalid");
		return new InvalidResponse(invalidFields, "data notfound message");
	}

	@Inject
	protected Validator validator;

	@Path("/validateBean")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseBase validateBean(@BeanParam SampleParent param) {
		Set<ConstraintViolation<SampleParent>> result = validator.validate(param);
		if (!result.isEmpty()) {
			return new InvalidResponse(result);
		}
		return new SuccessResponse(null);
	}

}
