package com.mpqh.preauth.service.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mpqh.preauth.model.Code;
import com.mpqh.preauth.service.CodeBuilderService;

@Service("csvCodeBuilderService")
public class CsvCodeBuilderService implements CodeBuilderService {

	@Override
	public List<Code> buildCodes(InputStream inputStream) throws Exception {
		
		List<Code> codes = new ArrayList<Code>();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		
		while (reader.ready()) {
			
			String nextLine = reader.readLine();
			List<String> nextElements = Arrays.asList(nextLine.split("\\s*,\\s*"));
			
			Code nextCode = new Code();
			
			String codeString = nextElements.get(0);
			String preauthString = nextElements.get(1);
			String sourceString = nextElements.get(2);
			
			
			nextCode.setCode(codeString);
			nextCode.setPreauth(preauthString.equalsIgnoreCase("y"));
			nextCode.setSource(sourceString);
			
			codes.add(nextCode);
			
			
		}
		
		return codes;
	}

	@Override
	public List<String> buildCodeList(String csvList) {
		return Arrays.asList(csvList.split("\\s*,\\s*"));
	}

}
