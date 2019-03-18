package com.mpqh.preauth.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpqh.preauth.model.Code;
import com.mpqh.preauth.repository.CodeRespository;
import com.mpqh.preauth.service.PreauthService;

@Service("simplePreauthService")
public class SimplePreauthService implements PreauthService {

	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	CodeRespository codeRepository;
	
	@Autowired
	public SimplePreauthService(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public Iterable<Code> getCodes(List<String> codes) {
		//return codeRepository.findAllById(codes);
		return codeRepository.findAllByCode(codes);
		
		
	}

	@Override
	public void saveCodes(List<Code> codes) {
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		codeRepository.deleteAll();
		codes.forEach(code -> entityManager.merge(code));
		entityManager.getTransaction().commit();
		entityManager.close();
		
	}

}
