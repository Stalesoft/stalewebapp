package com.mpqh.preauth.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PreauthEvaluation {
	
	
	private List<Code> codes = new ArrayList<Code>();
	

	public List<Code> getCodes() {
		return codes;
	}

	public void setCodes(List<Code> codes) {
		this.codes = codes;
	}
	
	public void addCode(Code code) {
		codes.add(code);
	}

}
