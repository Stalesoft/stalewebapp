package com.mpqh.preauth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@IdClass(CodePK.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Code {
	
	@Id
	private String code;
	@Id
	private String source;
	
	private Boolean preauth;
	
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
	
	@Override
	public boolean equals(Object obj) {
		
		
		if (this == obj) {
			return true;
		}
		
		if ((this.code == null || this.source == null) || obj == null || !(this.getClass().equals(obj.getClass()))) {
			return false;
		}
		
		CodePK c = (CodePK)obj;
		
		return this.code.equals(c.getCode()) && this.source.equals(c.getSource());
		
		
	}
	
	@Override
	public int hashCode() {
		return code == null ? 0 : code.hashCode();
	}
}
