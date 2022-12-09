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

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostsApiController {
	
	private final PostsService postsService;
	
	@PostMapping("/api/v1/posts")
	public Long save(@RequestBody PostsSaveRequestDto requestDto) {
		return postsService.save(requestDto);
	}
	
	@PutMapping("/api/v1/posts/{id}")
	public Long Update(@PathVariable("id") Long id, @RequestBody PostUpdateRequestDto requestDto) {
		// PathVariable 이란 Uri 들어가는 변수를 할당해줌
		return postsService.update(id, requestDto);
	}
	
	@GetMapping("/api/v1/posts/{id}")
	public PostsResponseDto findById(@PathVariable("id") Long id) {
		return postsService.findById(id);
	}

}
