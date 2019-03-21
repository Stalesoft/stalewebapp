package com.mpqh.preauth.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mpqh.preauth.model.Code;

public interface CodeRespository extends CrudRepository<Code, Integer> {

	@Query( value = "select * from CODE c where c.CODE in (:codes)", nativeQuery = true)
	public List<Code> findAllByCode(@Param("codes") List<String> coder);
	
}
