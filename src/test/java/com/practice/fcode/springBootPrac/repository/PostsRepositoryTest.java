package com.practice.fcode.springBootPrac.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.practice.fcode.springBootPrac.entity.Posts;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ExtendWith(SpringExtension.class)
@SpringBootTest
class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;
	
//	@AfterAll
//	public void cleanUp() {
//		postsRepository.deleteAll();
//	}
	
//	@Test
//	@DisplayName("게시글 저장 불러오기")
//	public void saveReturn() {
//		
//		// given
//		String title = "테스트 게시글";
//		String content = "테스트 본문";
//		
//		Posts saveData = Posts.builder()
//				.title(title)
//				.content(content)
//				.author("hahaha@gamil.com")
//				.build();
//		
//		postsRepository.save(saveData);
//		
//		// when
//		List<Posts> postsList = postsRepository.findAll();
//		
//		// then
//		Posts posts = postsList.get(0);
//		assertThat(posts.getTitle()).isEqualTo(title);
//		assertThat(posts.getContent()).isEqualTo(content);
//
//	}
	
	@Test
	@DisplayName("등록/수정 시간 등록")
	public void BaseTimeEntity() {
		// given
		LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
		
		log.info("뭐냐 now >>>>>>>>> {}" , now);
		
		postsRepository.save(Posts.builder()
				.title("title 하핫")
				.content("content 후훗")
				.author("홍길동")
				.build());
		
		// when
		List<Posts> postsList = postsRepository.findAll();
		
		// then
		log.info("뭐냐 postsList >>>>>>>>> {}" , postsList);
		
		for(Posts po : postsList) {
			log.info("CreatedDate >>>> {}" , po.getCreatedDate());
			log.info("ModifiedDate >>>> {}" , po.getModifiedDate());
		}
	}
	
}
