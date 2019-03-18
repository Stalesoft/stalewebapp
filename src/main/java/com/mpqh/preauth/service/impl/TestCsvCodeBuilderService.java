package com.mpqh.preauth.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mpqh.preauth.model.Code;
import com.mpqh.preauth.service.CodeBuilderService;

@Service("testCodeBuilderService")
public class TestCsvCodeBuilderService implements CodeBuilderService {

	@Override
	public List<Code> buildCodes(InputStream inputStream) {
		ArrayList<Code> codeList = new ArrayList<>();
		
		Code code = new Code();
		code.setCode("A1");
		code.setNotes("Notes");
		code.setPreauth(Boolean.TRUE);
		code.setSource("https://medicaidprovider.mt.gov/27#184022460-fee-schedules--physician\r\n");
		
		codeList.add(code);
		
		return codeList;
	}

	@Override
	public List<String> buildCodeList(String csvList) {
		return Arrays.asList(csvList.split("\\s*,\\s*"));
	}

}
