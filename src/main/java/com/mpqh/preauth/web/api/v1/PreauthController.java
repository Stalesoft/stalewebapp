package com.mpqh.preauth.web.api.v1;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mpqh.preauth.model.PreauthEvaluation;
import com.mpqh.preauth.repository.CodeRespository;
import com.mpqh.preauth.service.PreauthService;

@RestController
@RequestMapping("api/v1")
public class PreauthController {
	
	private static Logger log = LoggerFactory.getLogger(PreauthController.class);

	@Autowired
	@Qualifier("cachedPreauthService")
	PreauthService preauthService;
	
	@RequestMapping(value = "/preauth", method = RequestMethod.GET)
	public PreauthEvaluation getPrequth(@RequestParam("codes") String codes) {
		
		log.debug("codes are " + codes);
		
		PreauthEvaluation preauthEvaluation = new PreauthEvaluation();
		
		ArrayList<Integer> codeList = new ArrayList<>();
		codeList.add(1);
		
		synchronized (preauthService) {
			preauthEvaluation.setCodes(preauthService.getAllCodes(codeList));	
		}
		
		return preauthEvaluation;
		
	}
	
}
