package com.mpqh.preauth.service;

import java.util.List;

import com.mpqh.preauth.model.Code;

public interface PreauthService {
	
	public Iterable<Code> getCodes(List<String> codes);
	public void saveCodes(List<Code> codes);

}
