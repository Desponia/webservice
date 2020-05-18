package com.coalcellar.webservice.service;

import com.coalcellar.webservice.dto.posts.PostSaveRequestDto;
import com.coalcellar.webservice.domain.posts.PostsRepository;
import com.coalcellar.webservice.dto.posts.PostMainResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostsService {

    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public List<PostMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
