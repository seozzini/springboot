package com.example.demo.posts.domain;

import org.springframework.data.jpa.repository.JpaRepository; //스프링 제공 모듈

public interface PostsRepository extends JpaRepository<Posts, Long> {
//조회,소팅 이미 들어가있음
}
