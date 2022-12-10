package com.practice.fcode.springBootPrac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.fcode.springBootPrac.dto.HelloResponseDto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class HelloController {
	
	@ApiResponses({
        @ApiResponse(code = 200, message = "ok"),
        @ApiResponse(code = 404, message = "page not found")
	})
	@ApiOperation(value = "Hello", notes = "Hello.")
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@ApiResponses({
        @ApiResponse(code = 200, message = "ok"),
        @ApiResponse(code = 404, message = "page not found")
	})
	@ApiOperation(value = "Hello222", notes = "Hello.2222")
	@GetMapping("/hello/dto")
	public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
		
		return new HelloResponseDto(name, amount);
	}

}
