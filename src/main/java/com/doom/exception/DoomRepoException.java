package com.doom.exception;

public class DoomRepoException extends DoomException {
	private static final long serialVersionUID = 1L;

	public DoomRepoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DoomRepoException(Throwable cause) {
		super(cause);
	}

	public DoomRepoException(String message) {
		super(message);
	}
}
