package com.coalcellar.webservice.dto.posts;

import com.coalcellar.webservice.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class PostMainResponseDto {
    private Long id;
    private String title;
    private String author;
    private String modifiedDate;

    public PostMainResponseDto(Posts entity) {
        id = entity.getId();
        title = entity.getTitle();
        author = entity.getAuthor();
        modifiedDate = toStringDateTime(entity.getModifiedDate());
    }

    private String toStringDateTime(LocalDateTime modifiedDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(modifiedDate)
                .map(formatter::format)
                .orElse("");
    }
}
