package com.mpqh.preauth.web.api.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mpqh.preauth.exception.ServiceException;
import com.mpqh.preauth.model.ServiceError;

@ControllerAdvice
public class ExceptionController {

	public static final String NOT_FOUND_CODE = "Not Found";
	public static final String SERVICE_UNAVAILABLE_CODE = "Service Error";
	public static final String UNEXPECTED_ERROR_CODE = "Unexpected System Error";

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ServiceError> serviceError(ServiceException ex) {
		ServiceError response = new ServiceError();
		response.setErrorCode(NOT_FOUND_CODE);
		response.setErrorMessage(ex.getMessage());

		return new ResponseEntity<ServiceError>(response, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ServiceError> generalError(Exception ex) {
		ServiceError response = new ServiceError();
		response.setErrorCode(UNEXPECTED_ERROR_CODE);
		response.setErrorMessage(ex.getMessage());

		return new ResponseEntity<ServiceError>(response, HttpStatus.INTERNAL_SERVER_ERROR);

	}

}