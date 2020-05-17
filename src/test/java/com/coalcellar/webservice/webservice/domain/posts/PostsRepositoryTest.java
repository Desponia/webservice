package com.coalcellar.webservice.webservice.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {

//        given
        postsRepository.save(Posts.builder().title("테스트 게시 타이틀").content("테스트 컨텐츠다").author("Desponia").build());

//        when
        List<Posts> postsList = postsRepository.findAll();

//        then
        Posts posts = postsList.get(0);
        assert(posts.getTitle()).equals("테스트 게시 타이틀");
        assert(posts.getContent()).equals("테스트 컨텐츠다");
        assert(posts.getAuthor()).equals("Desponia");
    }

}