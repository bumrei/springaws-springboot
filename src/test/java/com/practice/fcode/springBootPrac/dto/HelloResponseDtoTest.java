package com.practice.fcode.springBootPrac.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HelloResponseDtoTest {

	@Test
	@DisplayName("롬북 기능 테스트")
	void test() {
		
		// given
		String name = "test";
		String name2 = "test22";
		int amount = 1000;
		
		// when
		HelloResponseDto dto = new HelloResponseDto(name, amount);
		
		// then
		assertThat(dto.getName()).isEqualTo(name2);
		assertThat(dto.getAmount()).isEqualTo(amount);
		
	}

}
