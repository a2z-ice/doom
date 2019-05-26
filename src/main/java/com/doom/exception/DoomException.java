package com.doom.exception;

public class DoomException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DoomException(String message, Throwable cause) {
		super(message, cause);
	}

	public DoomException(Throwable cause) {
		super(cause);
	}

	public DoomException(String message) {
		super(message);
	}
}
