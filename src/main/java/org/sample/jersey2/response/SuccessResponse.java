package org.sample.jersey2.response;

public class SuccessResponse extends ResponseBase {

	public SuccessResponse() {
		super.setReturnCode(RETURN_CODE_SUCCESS);
	}

	public SuccessResponse(String message) {
		super.setReturnCode(RETURN_CODE_SUCCESS);
		super.setMessage(message);
	}

	public SuccessResponse(Object value) {
		super.setReturnCode(RETURN_CODE_SUCCESS);
		super.setValue(value);
	}

	public SuccessResponse(Object value, String message) {
		super.setReturnCode(RETURN_CODE_SUCCESS);
		super.setValue(value);
		super.setMessage(message);
	}
}
