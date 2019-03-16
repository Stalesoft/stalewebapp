package com.mpqh.preauth.web.api.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mpqh.preauth.model.Code;
import com.mpqh.preauth.model.PreauthEvaluation;

@RestController
@RequestMapping("api/v1")
public class PreauthController {
	
	private static Logger log = LoggerFactory.getLogger(PreauthController.class);


	@RequestMapping(value = "/preauth", method = RequestMethod.GET)
	public PreauthEvaluation getPrequth(@RequestParam("repository") String codes) {
		
		log.debug("codes are " + codes);
		
		PreauthEvaluation preauthEvaluation = new PreauthEvaluation();
		
		Code code = new Code();
		code.setAuthorizingSource("NURSE");
		code.setCode("BZ1332");
		code.setNeedPreauth(Boolean.TRUE);
		code.setNotes("Only if over 21");
		preauthEvaluation.addCode(code);
		
		return preauthEvaluation;
		
	}
	
}
