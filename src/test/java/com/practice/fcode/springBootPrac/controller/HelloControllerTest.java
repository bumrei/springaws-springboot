package com.practice.fcode.springBootPrac.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.practice.fcode.springBootPrac.dto.HelloResponseDto;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
class HelloControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	HelloController controller;

	@Test
	@DisplayName("hello 가 리턴된다.")
//	@Disabled
	public void helloReturn() throws Exception {
		String hello = "hello";
		
		mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
	}
	
	@Test
	@DisplayName("dto 객체 리턴 받아보기")
	public void h() throws Exception {
		
		String name = "hello";
		int amount = 1000;
		
		mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
									.andExpect(status().isOk())
									.andExpect(jsonPath("$.name", is(name)))
									.andExpect(jsonPath("$.amount" , is(amount)));
	}

}
