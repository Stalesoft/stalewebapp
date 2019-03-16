package com.mpqh.preauth.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Code {
	
	private String code;
	private Boolean needPreauth;
	private String authorizingSource;
	private String notes;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Boolean getNeedPreauth() {
		return needPreauth;
	}
	public void setNeedPreauth(Boolean needPreauth) {
		this.needPreauth = needPreauth;
	}
	public String getAuthorizingSource() {
		return authorizingSource;
	}
	public void setAuthorizingSource(String authorizingSource) {
		this.authorizingSource = authorizingSource;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

}
