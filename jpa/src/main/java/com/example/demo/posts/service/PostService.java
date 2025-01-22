package com.example.demo.posts.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.posts.domain.Posts;
import com.example.demo.posts.domain.PostsRepository;
import com.example.demo.posts.web.dto.PostResponseDto;
import com.example.demo.posts.web.dto.PostsListResponseDto;
import com.example.demo.posts.web.dto.PostsSaveRequestDto;
import com.example.demo.posts.web.dto.PostsUpdateRequestDto;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {
	private final PostsRepository postsRepository;
	
	//등록
	@Transactional
	public Long Save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity()).getId();
	}
	
	//수정
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id) //기본키로 단건조회
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent()); //제목과 내용만 update 메서드로 entity 변경

        return id;
    }
	
	//삭제
	//delete(){}
	
	//전체조회
	public List<PostsListResponseDto> findAll(){
		List<Posts> list = postsRepository.findAll();
		
		//List<PostsListResponseDto> dtoList = new ArrayList<>();
		//list.forEach(post -> dtoList.add(new PostsListResponseDto(post) )); 
		//return dtoList;
		
		//위 세 줄을 stream 으로 변경 시 한 줄로 가능함. (다양한 함수 포함)
		return list.stream().map(post -> new PostsListResponseDto(post))
				            .collect(Collectors.toList());
		
	}  
	
	//단건조회
	public PostResponseDto findById(Long id) {
		Optional<Posts> post = postsRepository.findById(id); //notnull도 null처리하기 위해 자바에서 제공
		return new PostResponseDto(post.get());		
	}

}
