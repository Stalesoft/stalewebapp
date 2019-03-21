package com.mpqh.preauth.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PriorAuthEvaluation {
	
	
	private Iterable<Code> codes = new ArrayList<Code>();
	

	public Iterable<Code> getCodes() {
		return codes;
	}

	public void setCodes(Iterable<Code> codes) {
		this.codes = codes;
	}
	

}
