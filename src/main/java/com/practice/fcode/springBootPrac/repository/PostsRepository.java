package com.practice.fcode.springBootPrac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.fcode.springBootPrac.entity.Posts;

public interface PostsRepository extends JpaRepository<Posts, Long> {

}
