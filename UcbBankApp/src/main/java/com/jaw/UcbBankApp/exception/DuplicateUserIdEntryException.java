package com.jaw.UcbBankApp.exception;

public class DuplicateUserIdEntryException extends Exception {

	private static final long serialVersionUID = 1L;

	public DuplicateUserIdEntryException(String msg) {
		super(msg);
	}
}