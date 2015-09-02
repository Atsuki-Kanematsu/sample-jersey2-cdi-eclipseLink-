package org.sample.jersey2.response;

public class IllegalResponse extends ResponseBase {

	public IllegalResponse(Exception ex) {
		super.setReturnCode(RETURN_CODE_ILLEGAL);
		super.setMessage(ex.getMessage());
		super.setValue(ex.getStackTrace());
	}

	public IllegalResponse(String message) {
		super.setReturnCode(RETURN_CODE_ILLEGAL);
		super.setMessage(message);
	}

}
