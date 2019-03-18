package com.mpqh.preauth.service.impl;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mpqh.preauth.model.Code;
import com.mpqh.preauth.service.CodeBuilderService;

@Service("csvCodeBuilderService")
public class CsvCodeBuilderService implements CodeBuilderService {

	@Override
	public List<Code> buildCodes(InputStream inputStream) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buildCodeList(String csvList) {
		return Arrays.asList(csvList.split("\\s*,\\s*"));
	}

}
