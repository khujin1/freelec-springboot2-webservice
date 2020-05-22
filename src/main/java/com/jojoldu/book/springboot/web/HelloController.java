package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //public HelloController (){} //default 생성. 생략 가능

    @GetMapping("/hello")
    // hello Method 정의
    public String hello() {
        return "hello";
    }


    // HelloResponseDto Method 정
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, // 외부에서 API로 넘긴 파라미터를 가져오 어노테이션
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name,amount);
    }
}
