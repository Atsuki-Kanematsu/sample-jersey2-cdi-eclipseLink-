package org.sample.jersey2.response;

import java.util.Map;

public class ResponseBase {

	public static final String RETURN_CODE_SUCCESS = "0000";
	public static final String RETURN_CODE_NOTFOUND = "0001";
	public static final String RETURN_CODE_INVALID = "0002";
	public static final String RETURN_CODE_ILLEGAL = "9999";

	protected String returnCode;
	protected String message;
	protected Map<String, String> invalidFields;
	protected Object value;

	public String getReturnCode() {
		return returnCode;
	}
	protected void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getMessage() {
		return message;
	}
	protected void setMessage(String message) {
		this.message = message;
	}

	public Map<String, String> getInvalidFields() {
		return invalidFields;
	}
	protected void setInvalidFields(Map<String, String> invalidFields) {
		this.invalidFields = invalidFields;
	}

	public Object getValue() {
		return value;
	}
	protected void setValue(Object value) {
		this.value = value;
	}


}
