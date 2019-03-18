package com.mpqh.preauth.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.mpqh.preauth.model.Code;
import com.mpqh.preauth.service.PreauthService;

@Service("cachedPreauthService")
public class CachedPreauthService implements PreauthService {

	Logger logger = LoggerFactory.getLogger(CachedPreauthService.class);

	public static final String CACHE_ID = "simple_cache";
	public static final int CACHE_TTL = 900000;
	  
	@Autowired
	@Qualifier("simplePreauthService")
	PreauthService preauthService;
	
	@Cacheable(CACHE_ID)
	@Override
	public Iterable<Code> getCodes(List<String> codes) {
		logger.debug("Grabbing codes");
		return preauthService.getCodes(codes);
	}

	@CacheEvict(allEntries = true, cacheNames = {CACHE_ID})
	@Scheduled(fixedDelay = CACHE_TTL)
	public void cacheEvict() {
	    logger.debug("cache: {} evicted", CACHE_ID);
	}

	@Override
	public void saveCodes(List<Code> codes) {
		preauthService.saveCodes(codes);
	}
}
