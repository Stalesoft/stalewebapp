package com.mpqh.preauth.web.api.v1;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mpqh.preauth.model.PriorAuthEvaluation;
import com.mpqh.preauth.service.CodeBuilderService;
import com.mpqh.preauth.service.PriorAuthService;

@RestController
@RequestMapping("api/v1")
public class PriorAuthController {
	
	private static Logger log = LoggerFactory.getLogger(PriorAuthController.class);

	@Autowired
	@Qualifier("cachedPriorAuthService")
	PriorAuthService priorAuthService;
	

	@Autowired
	@Qualifier("csvCodeBuilderService")
	CodeBuilderService codeBuilderService;
	
	@RequestMapping(value = "/priorauth", method = RequestMethod.GET)
	public PriorAuthEvaluation getPriorAuth(@RequestParam("codes") String codes) {
		
		log.debug("codes are " + codes);
		
		PriorAuthEvaluation priorAuthEvaluation = new PriorAuthEvaluation();
		
		List<String> codeList = codeBuilderService.buildCodeList(codes);

		synchronized (priorAuthService) {
			priorAuthEvaluation.setCodes(priorAuthService.getCodes(codeList));	
		}
		
		return priorAuthEvaluation;
		
	}
	
}
