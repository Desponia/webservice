package com.coalcellar.webservice.webservice.service;

import com.coalcellar.webservice.web.PostSaveRequestDto;
import com.coalcellar.webservice.webservice.domain.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class PostsService {

    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }
}
