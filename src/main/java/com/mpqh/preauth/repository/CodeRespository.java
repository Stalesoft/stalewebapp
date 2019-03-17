package com.mpqh.preauth.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mpqh.preauth.model.Code;

public interface CodeRespository extends CrudRepository<Code, Integer> {

	public List<Code> findAllByCode(List<String> code);
}
