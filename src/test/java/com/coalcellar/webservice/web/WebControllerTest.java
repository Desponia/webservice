package com.coalcellar.webservice.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

// https://ict-nroo.tistory.com/96
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩() {
//        when
        String body = this.restTemplate.getForObject("/", String.class);

        assert (body.contains("Boot, ec2, S3, CodeDeploy, Travis CI 와 함께하는 게시판 놀이"));
    }

}