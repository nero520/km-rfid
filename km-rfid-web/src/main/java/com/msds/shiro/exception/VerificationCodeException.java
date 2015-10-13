package com.msds.shiro.exception;

import org.apache.shiro.authc.AuthenticationException;

@SuppressWarnings("serial")
public class VerificationCodeException extends AuthenticationException {

	/**
	 * Creates a new AuthenticationException.
	 */
	public VerificationCodeException() {
		super();
	}

	/**
	 * Constructs a new AuthenticationException.
	 * 
	 * @param message
	 *            the reason for the exception
	 */
	public VerificationCodeException(String message) {
		super(message);
	}

	/**
	 * Constructs a new AuthenticationException.
	 * 
	 * @param cause
	 *            the underlying Throwable that caused this exception to be
	 *            thrown.
	 */
	public VerificationCodeException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs a new AuthenticationException.
	 * 
	 * @param message
	 *            the reason for the exception
	 * @param cause
	 *            the underlying Throwable that caused this exception to be
	 *            thrown.
	 */
	public VerificationCodeException(String message, Throwable cause) {
		super(message, cause);
	}
}
