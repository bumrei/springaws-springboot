package com.practice.fcode.springBootPrac.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor

public class PostUpdateRequestDto {
	
	private String title;
	private String content;

}
