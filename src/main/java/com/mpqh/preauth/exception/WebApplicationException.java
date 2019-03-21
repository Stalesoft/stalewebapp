package com.mpqh.preauth.exception;

public class WebApplicationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	private Long resourceId;

	public WebApplicationException(Long resourceId, String message) {
		super(message);
		this.resourceId = resourceId;
	}

	public Long getResourceId() {
		return resourceId;
	}
}