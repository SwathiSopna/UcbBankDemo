package com.jaw.UcbBankApp.controller;

import java.util.Optional;

import org.springframework.hateoas.mediatype.vnderrors.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jaw.UcbBankApp.exception.DuplicateUserIdEntryException;

@ControllerAdvice

@RequestMapping(produces = "application/vnd.error+json")
public class UserControllerAdvice {
	 @ResponseBody
	    @ExceptionHandler(DuplicateUserIdEntryException.class)
	   @ResponseStatus(HttpStatus.CONFLICT)
	/* public ResponseEntity < VndErrors > DuplicateUserIdEntryExceptionHandler(final DuplicateUserIdEntryException e) {
	        return error(e, HttpStatus.CONFLICT, e.getMessage().toString());
	    }
	 private ResponseEntity < VndErrors > error(final Exception exception, final HttpStatus httpStatus, final String logRef) {
	        final String message = Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
	        return new ResponseEntity < > (new VndErrors(logRef, message), httpStatus);
	    }*/
	    VndErrors DuplicateUserIdEntryExceptionHandler(DuplicateUserIdEntryException ex) {
	        return new VndErrors("error", ex.getMessage());
	    }
}
