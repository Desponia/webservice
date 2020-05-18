package com.coalcellar.webservice.webservice.service;

import com.coalcellar.webservice.web.PostSaveRequestDto;
import com.coalcellar.webservice.webservice.domain.posts.Posts;
import com.coalcellar.webservice.webservice.domain.posts.PostsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PostsServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void DTO데이터가_posts테이블에_저장된다() {
        PostSaveRequestDto dto = PostSaveRequestDto.builder()
                .author("email@gmail.com")
                .content("test content")
                .title("test title")
                .build();

        postsService.save(dto);

        Posts posts = postsRepository.findAll().get(0);
        assertEquals(posts.getAuthor(), dto.getAuthor());
        assertEquals(posts.getTitle(), dto.getTitle());
        assertEquals(posts.getContent(), dto.getContent());
    }

}