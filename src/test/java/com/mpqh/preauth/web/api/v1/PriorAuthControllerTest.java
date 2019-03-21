package com.mpqh.preauth.web.api.v1;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc()
public class PriorAuthControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	@Ignore
	public void testPriorAuth_shouldGetAnEvaluation() {
		//TODO
	}
	
}
