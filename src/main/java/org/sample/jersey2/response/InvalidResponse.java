package org.sample.jersey2.response;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.validation.ConstraintViolation;

public class InvalidResponse extends ResponseBase {

	public <T> InvalidResponse(Set<ConstraintViolation<T>> violations) {
		super.invalidFields = new HashMap<>();
		for (ConstraintViolation<T> violation : violations) {
			String invalidMessage = buildMessage(violation.getMessage());
			invalidFields.put(violation.getPropertyPath().toString(), invalidMessage);
		}
	}

	public <T> InvalidResponse(Set<ConstraintViolation<T>> violations, String message) {
		super.invalidFields = new HashMap<>();
		for (ConstraintViolation<T> violation : violations) {
			String invalidMessage = buildMessage(violation.getMessage());
			invalidFields.put(violation.getPropertyPath().toString(), invalidMessage);
		}
		super.message = message;
	}

	public InvalidResponse(Map<String, String> invalidFields) {
		super.setInvalidFields(invalidFields);
	}

	public InvalidResponse(Map<String, String> invalidFields, String message) {
		super.setInvalidFields(invalidFields);
		super.setMessage(message);
	}

	protected static String buildMessage(String message) {
		ResourceBundle bundle = ResourceBundle.getBundle("message");
		StringBuffer sb = new StringBuffer();
		int lastFoundPos = 0;
		do {
			int start = message.indexOf("{", lastFoundPos);
			if (start == -1) {
				break;
			}
			int end = message.indexOf("}", start + 1);
			if (end == -1) {
				break;
			}
			sb.append(message.substring(lastFoundPos, start));
			lastFoundPos = end + 1;
			String key = message.substring(start + 1, end);
			sb.append(bundle.getString(key));
		} while(true);
		sb.append(message.substring(lastFoundPos));
		return sb.toString();
	}
}
