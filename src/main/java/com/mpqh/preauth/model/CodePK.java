package com.mpqh.preauth.model;

import java.io.Serializable;

public class CodePK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	String code;
	String source;
	
	public CodePK() {}
	
	public CodePK(String code, String source) {
		this.code = code;
		this.source = source;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	public String getSource() {
		return source;
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
