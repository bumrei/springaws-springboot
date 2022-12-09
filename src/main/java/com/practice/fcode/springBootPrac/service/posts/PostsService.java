package com.practice.fcode.springBootPrac.service.posts;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.fcode.springBootPrac.dto.PostUpdateRequestDto;
import com.practice.fcode.springBootPrac.dto.PostsResponseDto;
import com.practice.fcode.springBootPrac.dto.PostsSaveRequestDto;
import com.practice.fcode.springBootPrac.entity.Posts;
import com.practice.fcode.springBootPrac.repository.PostsRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostsService {
	private final PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity()).getId();
	}
	
	@Transactional
	public Long update(Long id, PostUpdateRequestDto requestDto) {
		Posts posts = postsRepository.findById(id).orElseThrow(() 
				-> new IllegalArgumentException("해당 게시글 없음. id="+id));
		
		posts.update(requestDto.getTitle(), requestDto.getContent());
		
		return id;
	}
	
	public PostsResponseDto findById(Long id) {
		Posts entity = postsRepository.findById(id).orElseThrow(() ->
				new IllegalArgumentException("해당 게시글 없음. id = " + id));
		return new PostsResponseDto(entity);
	}
}
