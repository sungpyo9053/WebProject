package com.webproject.webprojectboard.repository;

import com.webproject.webprojectboard.config.JpaConfig;
import com.webproject.webprojectboard.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Jap Connection Testing")
@DataJpaTest
@Import(JpaConfig.class)
class JpaRepositoryTest {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(@Autowired ArticleRepository articleRepository, @Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @DisplayName("update Testing")
    @Test
    void givenTestData_WhenSelecting_thenWorksFine()
    {

        Article article = articleRepository.findById(1L).orElseThrow();
        String updateHashtag = "#springboot";
        article.setHashtag(updateHashtag);

        Article savedArticle = articleRepository.saveAndFlush(article);


        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag", updateHashtag);

    }
    @DisplayName("deleting Testing")
    @Test
    void givenTestData_WhenDeleting_thenWorksFine()
    {
        Article article = articleRepository.findById(1L).orElseThrow();
        long previousAriticleCount = articleRepository.count();
        long previousArticleCommentCount = articleCommentRepository.count();
        long deletedCommentSize = article.getArticleComments().size();

        String updateHashtag = "#springboot";
        article.setHashtag(updateHashtag);

        articleRepository.delete(article);


        assertThat(articleRepository.count()).isEqualTo(previousAriticleCount -1);






    }


}

