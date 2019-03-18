package com.mpqh.preauth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Code {
	
	@Id
	@GeneratedValue
	private Integer codeId;
	private String code;
	private Boolean preauth;
	private String source;
	private String notes;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Boolean isPreauth() {
		return preauth;
	}
	public void setPreauth(Boolean preauth) {
		this.preauth = preauth;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Integer getCodeId() {
		return codeId;
	}
	public void setCodeId(Integer codeId) {
		this.codeId = codeId;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {
			return true;
		}
		
		if (this.codeId == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
			return false;
		}
		
		Code c = (Code)obj;
		
		return this.codeId.equals(c.getCodeId());
		
	}
	
	@Override
	public int hashCode() {
		return codeId == null ? 0 : codeId.hashCode();
	}
}
