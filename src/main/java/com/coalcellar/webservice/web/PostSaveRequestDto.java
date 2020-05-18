package com.coalcellar.webservice.web;

import com.coalcellar.webservice.webservice.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Controller에서 @RequestBody로 외부에서 데이터를 받는 경우엔 기본생성자 + set메소드를 통해서만 값이 할당됩니다.
//그래서 이때만 setter를 허용합니다.
@Getter
@Setter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String title;
    private String content;
    private String author;

    public Posts toEntity() {
        return Posts.builder().title(title)
                .content(content)
                .author(author)
                .build();
    }
}
