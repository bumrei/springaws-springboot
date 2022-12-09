package com.practice.fcode.springBootPrac.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.practice.fcode.springBootPrac.entity.Posts;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;
	
//	@AfterAll
//	public void cleanUp() {
//		postsRepository.deleteAll();
//	}
	
	@Test
	@DisplayName("게시글 저장 불러오기")
	public void saveReturn() {
		
		// given
		String title = "테스트 게시글";
		String content = "테스트 본문";
		
		Posts saveData = Posts.builder()
				.title(title)
				.content(content)
				.author("hahaha@gamil.com")
				.build();
		
		postsRepository.save(saveData);
		
		// when
		List<Posts> postsList = postsRepository.findAll();
		
		// then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle()).isEqualTo(title);
		assertThat(posts.getContent()).isEqualTo(content);

	}
	
}
