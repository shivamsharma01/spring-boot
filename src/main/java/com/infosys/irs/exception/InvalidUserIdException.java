package com.infosys.irs.exception;

public class InvalidUserIdException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidUserIdException(String message) {
		super(message);
	}
}
