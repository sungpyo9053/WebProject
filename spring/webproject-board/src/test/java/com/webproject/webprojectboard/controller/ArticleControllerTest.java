package com.webproject.webprojectboard.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(ArticleController.class)
class ArticleControllerTest
{

    private final MockMvc mvc;

    public ArticleControllerTest(@Autowired MockMvc mvc)
    {
        this.mvc = mvc;
    }


    @DisplayName("call page Success")
    @Test
    public void given_whenRequestingViewController_then() throws Exception
    {
        mvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles")); // 데이터가 있는지, article

    }

    @DisplayName("Detail Page call Success")
    @Test
    public void given_whenRequestingViewController_thenArticleView() throws Exception
    {
        mvc.perform(get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles")); // 데이터가 있는지, article

    }

    @DisplayName("Search Page call Success")
    @Test
    public void givenSearch_whenRequestingViewController_thenArticleView() throws Exception
    {
        mvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.TEXT_HTML));
                //.andExpect(model().attributeExists("articles")); // 데이터가 있는지, article

    }



    @DisplayName("Hashtag Search Page call Success")
    @Test
    public void givenHashSearch_whenRequestingViewController_thenArticleView() throws Exception
    {
        mvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.TEXT_HTML));
        //.andExpect(model().attributeExists("articles")); // 데이터가 있는지, article

    }

}