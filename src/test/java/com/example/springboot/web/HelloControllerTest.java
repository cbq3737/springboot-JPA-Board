package com.example.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello ="hello"  ;

        mvc.perform(get("/hello")).andExpect(status().isOk())
                                            .andExpect(content().string(hello));
    }
    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello"  ;
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name",name).param("amount",String.valueOf(amount))) //api태스트할때 사용될 요청 파라미터,값은 String값만
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name))) //JSON응답값을 필드별로 검증할 수 있는 메소드
                .andExpect(jsonPath("$.amount",is(amount)));//$를 기준으로 필드명을 명시한다.
    }
}
