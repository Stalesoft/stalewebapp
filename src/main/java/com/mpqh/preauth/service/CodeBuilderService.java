package com.mpqh.preauth.service;

import java.io.InputStream;
import java.util.List;

import com.mpqh.preauth.model.Code;

public interface CodeBuilderService {

	public List<Code> buildCodes(InputStream inputStream) throws Exception;
	
	public List<String> buildCodeList(String csvList);

}
