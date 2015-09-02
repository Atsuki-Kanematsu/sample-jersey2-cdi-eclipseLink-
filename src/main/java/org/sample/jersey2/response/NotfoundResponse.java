package org.sample.jersey2.response;

public class NotfoundResponse extends ResponseBase {

	public NotfoundResponse() {
		super.setReturnCode(RETURN_CODE_NOTFOUND);
	}
	public NotfoundResponse(String message) {
		super.setReturnCode(RETURN_CODE_NOTFOUND);
		super.setMessage(message);
	}

}
