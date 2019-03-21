package com.mpqh.preauth.web.app.controller;

import java.io.IOException;
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
import com.mpqh.preauth.service.PreauthService;


@Controller
@RequestMapping("app/preauth")
public class UploadController {
	

	private static Logger log = LoggerFactory.getLogger(UploadController.class);

	@Autowired
	@Qualifier("csvCodeBuilderService")
	CodeBuilderService codeBuilderService;

	@Autowired
	@Qualifier("cachedPreauthService")
	PreauthService preauthService;
	
	@GetMapping("/home")
	public String uploadHome(Model model) {

		log.debug("File Uploaded");
		//Need to list all codes
		return "app/preauth/upload";	
	}
	
	@PostMapping("/codes")
	public String uploadDocument(@RequestParam("file") MultipartFile uploadDocument, Model model) throws Exception {
		
		List<Code> codes = codeBuilderService.buildCodes(uploadDocument.getInputStream());
	
		preauthService.saveCodes(codes);
		
		return "app/preauth/upload";
	}

}
