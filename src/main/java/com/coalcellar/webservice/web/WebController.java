package com.coalcellar.webservice.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

//    @GetMapping은 이전으로 보면 @RequestMapping(value="/", method = RequestMethod.GET)과 동일
    @GetMapping("/")
    public String main() {
        return "main";
    }
}
