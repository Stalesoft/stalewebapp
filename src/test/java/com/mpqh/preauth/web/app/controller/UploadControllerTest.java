package com.mpqh.preauth.web.app.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mpqh.preauth.model.Code;
import com.mpqh.preauth.service.PriorAuthService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc()
public class UploadControllerTest {

	
	@Autowired
	MockMvc mockMvc;
	
	@Mock
	List<Code> mockCodes;
	
	@Test
	public void testHome_shouldReturnUploadTemplate() throws Exception {
		
		mockMvc.perform(get("/app/priorauth/home")).andExpect(view().name("app/preauth/upload"));
		
	}
	
	
	@Test
	public void testUpload_shouldUploadFile() throws Exception {
	
		MockMultipartFile mockUploadFile = new MockMultipartFile("data", "physcian.csv", "text/plain", "123,1234,3QA1".getBytes());
		
		mockMvc.perform(
				MockMvcRequestBuilders.multipart("/app/priorauth/codes")
				.file("file",mockUploadFile.getBytes()))
		.andExpect(status().is(200))
		.andExpect(view().name("app/preauth/upload"));
		
	}
	
}
