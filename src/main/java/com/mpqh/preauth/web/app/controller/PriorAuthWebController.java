package com.mpqh.preauth.web.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mpqh.preauth.model.Code;
import com.mpqh.preauth.service.CodeBuilderService;
import com.mpqh.preauth.service.PriorAuthService;

@Controller
@RequestMapping("app/priorauth")
public class PriorAuthWebController {

	private static Logger log = LoggerFactory.getLogger(PriorAuthWebController.class);

	@Autowired
	@Qualifier("csvCodeBuilderService")
	CodeBuilderService codeBuilderService;

	@Autowired
	@Qualifier("cachedPriorAuthService")
	PriorAuthService priorAuthService;

	@GetMapping("/home")
	public String uploadHome(Model model) {

		log.debug("File Uploaded");
		// Need to list all codes
		return "app/preauth/upload";
	}
	
	@GetMapping("/client")
	public String clientHome(Model model) {

		log.debug("File Uploaded");
		// Need to list all codes
		return "app/preauth/client";
	}

	@PostMapping("/codes")
	public String uploadDocument(@RequestParam("file") MultipartFile uploadDocument, Model model) throws Exception {

		try {
			
			
			List<Code> codes = codeBuilderService.buildCodes(uploadDocument.getInputStream());
			priorAuthService.saveCodes(codes);
			
		} catch (Exception e) {
			e.printStackTrace();//TODO: Error Handling.
			model.addAttribute("error", "Error uploading");
		}

		return "app/preauth/upload";
	}

}
