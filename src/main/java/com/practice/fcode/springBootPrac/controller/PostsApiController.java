package com.practice.fcode.springBootPrac.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.fcode.springBootPrac.dto.PostUpdateRequestDto;
import com.practice.fcode.springBootPrac.dto.PostsResponseDto;
import com.practice.fcode.springBootPrac.dto.PostsSaveRequestDto;
import com.practice.fcode.springBootPrac.service.posts.PostsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostsApiController {
	
	private final PostsService postsService;
	
	@ApiResponses({
        @ApiResponse(code = 200, message = "ok"),
        @ApiResponse(code = 404, message = "page not found")
	})
	@ApiOperation(value = "save", notes = "save.")
	@PostMapping("/api/v1/posts")
	public Long save(@RequestBody PostsSaveRequestDto requestDto) {
		return postsService.save(requestDto);
	}
	
	@ApiResponses({
        @ApiResponse(code = 200, message = "ok"),
        @ApiResponse(code = 404, message = "page not found")
	})
	@ApiOperation(value = "Update", notes = "Update.")
	@PutMapping("/api/v1/posts/{id}")
	public Long Update(@PathVariable("id") Long id, @RequestBody PostUpdateRequestDto requestDto) {
		// PathVariable 이란 Uri 들어가는 변수를 할당해줌
		return postsService.update(id, requestDto);
	}
	
	@ApiResponses({
        @ApiResponse(code = 200, message = "ok"),
        @ApiResponse(code = 404, message = "page not found")
	})
	@ApiOperation(value = "findById", notes = "findById.")
	@GetMapping("/api/v1/posts/{id}")
	public PostsResponseDto findById(@PathVariable("id") Long id) {
		return postsService.findById(id);
	}

}
