package com.mpqh.preauth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpqh.preauth.model.Code;
import com.mpqh.preauth.repository.CodeRespository;
import com.mpqh.preauth.service.PreauthService;

@Service("simplePreauthService")
public class SimplePreauthService implements PreauthService {

	
	@Autowired
	CodeRespository codeRepository;

	@Override
	public Iterable<Code> getAllCodes(List<Integer> codes) {
		return codeRepository.findAllById(codes);
	}

}
