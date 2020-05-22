package com.jojoldu.book.springboot.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) //스프링부트 테스트와 JUnit사이의 연결자 역할
@WebMvcTest(controllers = HelloController.class) // Web에 집중하는 어노테이션

public class HelloContrllerTest {

    @Autowired //
    private MockMvc mvc; // web api test

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc 통해 /hello 주소로 HTTP GET요청
            .andExpect(status().isOk()) // Http header status 검증. 200인지 아닌지 검증
            .andExpect(content().string(hello)); // 본문의 내용을 검증
    }
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
