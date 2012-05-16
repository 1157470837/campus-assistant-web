package com.techthinker.CAWeb.exception;

public class CampusNewsException extends RuntimeException {

	private static final long serialVersionUID = -8412165961002835819L;

	public CampusNewsException() {
		super();
	}

	public CampusNewsException(String message, Throwable cause) {
		super(message, cause);
	}

	public CampusNewsException(String message) {
		super(message);
	}

	public CampusNewsException(Throwable cause) {
		super(cause);
	}
	
}
