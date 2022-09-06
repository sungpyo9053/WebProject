package com.webproject.webprojectboard.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Data Rest -API Test")
@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class DataRestTest {
    private  final MockMvc mvc;
    public DataRestTest(@Autowired MockMvc mvc)
    {
        this.mvc = mvc;

    }

    @DisplayName("[api] board list")
    @Test
    void given_whenRequestingArticles_then() throws Exception {
        mvc.perform(get("/api/articles"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));


    }

    @DisplayName("[api] comment list")
    @Test
    void given_whenRequestingArticlesComment_then() throws Exception {
        mvc.perform(get("/api/articles/1/articleComments"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));


    }


    @DisplayName("[api] article comment list")
    @Test
    void given_whenRequestingArticlesCommentlist_then() throws Exception {
        mvc.perform(get("/api/articleComments"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));


    }


    @DisplayName("[api] article one comment list")
    @Test
    void given_whenRequestingArticlesCommentOnelist_then() throws Exception {
        mvc.perform(get("/api/articleComments/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.valueOf("application/hal+json")));

    }


}
