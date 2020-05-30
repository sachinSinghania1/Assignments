package com.modestack.Assignment.exception.helper;

import com.modestack.Assignment.exception.AssignmentException;

public class AssignmentServiceException extends AssignmentException {

	public AssignmentServiceException() {
		super();
	}

	public AssignmentServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AssignmentServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public AssignmentServiceException(String message) {
		super(message);
	}

	public AssignmentServiceException(Throwable cause) {
		super(cause);
	}

}
