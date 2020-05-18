package com.coalcellar.webservice.web;

import com.coalcellar.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {
    private PostsService postsService;

//    @GetMapping은 이전으로 보면 @RequestMapping(value="/", method = RequestMethod.GET)과 동일
    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }
}
