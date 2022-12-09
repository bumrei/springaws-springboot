package com.practice.fcode.springBootPrac.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.practice.fcode.springBootPrac.dto.PostUpdateRequestDto;
import com.practice.fcode.springBootPrac.dto.PostsSaveRequestDto;
import com.practice.fcode.springBootPrac.entity.Posts;
import com.practice.fcode.springBootPrac.repository.PostsRepository;

import lombok.extern.log4j.Log4j2;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
@Log4j2
class PostsApiControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTempate;
	
	@Autowired
	private PostsRepository postsRepository;
	
	@AfterAll
	public void tearDown() {
		postsRepository.deleteAll();
	}
	
//	@Test
//	@DisplayName("등록된다.")
//	void test1() throws Exception {
//		// given
//		String title = "title";
//		String content = "content";
//		PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
//				.title(title)
//				.content(content)
//				.author("author")
//				.build();
//		
//		String url = "http://localhost:" + port + "/api/v1/posts";
//		
//		
//		
//		// when
//		log.info("---- 등록 ----");
//		log.info("---- 등록 ----");
//		log.info("---- 등록 ----");
//		log.info("---- 등록 ----");
//		ResponseEntity<Long> responseEntity = restTempate.postForEntity(url, requestDto, Long.class);
//		
//		log.info("---- 등록 끝 ----");
//		log.info("---- 등록 끝 ----");
//		log.info("---- 등록 끝 ----");
//		log.info("---- 등록 끝 ----");
//
//		// then
//		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//		assertThat(responseEntity.getBody()).isGreaterThan(0L);
//		
//		List<Posts> all = postsRepository.findAll();
//		
//		System.out.println(all);
//		
//	}
	
	@Test
	@DisplayName("수정된다")
	void test2() throws Exception {
		// given
		
		log.info("---- 등록 ----");
		log.info("---- 등록 ----");
		log.info("---- 등록 ----");
		log.info("---- 등록 ----");
		Posts savedPost = postsRepository.save(Posts.builder()
				.title("This is title")
				.content("This is Content")
				.author("author")
				.build());
		
		List<Posts> all1 = postsRepository.findAll();
		
		log.info("등록 결과 >>>>> {}" , all1);
		
		log.info("---- 등록 끝 ----");
		log.info("---- 등록 끝 ----");
		log.info("---- 등록 끝 ----");
		log.info("---- 등록 끝 ----");
		
		Long updateId = savedPost.getId();
		String expectedTitle = "title2 수정 끝";
		String expectedContent = "content2 수정 끝";
		
		PostUpdateRequestDto requestDto = PostUpdateRequestDto.builder()
				.title(expectedTitle)
				.content(expectedContent)
				.build();
		
		String url = "http://localhost:" + port + "/api/v1/posts/" + updateId;
		
		HttpEntity<PostUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

		// when
		log.info("---- 수정 ----");
		log.info("---- 수정 ----");
		log.info("---- 수정 ----");
		log.info("---- 수정 ----");

		ResponseEntity<Long> responseEntity = restTempate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);
		
		log.info("---- 수정 끝 ----");
		log.info("---- 수정 끝 ----");
		log.info("---- 수정 끝 ----");
		log.info("---- 수정 끝 ----");

		// then
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isGreaterThan(0L);
		List<Posts> all2 = postsRepository.findAll();
		
		log.info("All =============== >> {}" , all2);
	
		
		
		
	}
	
}
