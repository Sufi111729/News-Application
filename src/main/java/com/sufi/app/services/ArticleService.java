package com.sufi.app.services;

import com.sufi.app.entity.Article;
import com.sufi.app.repositories.ArticleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article createArticle(Article article) {
        article.setCreatedAt(LocalDateTime.now());
        article.setUpdatedAt(LocalDateTime.now());
        return articleRepository.save(article);
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    public Article updateArticle(Long id, Article updatedArticle) {
        return articleRepository.findById(id)
            .map(article -> {
                article.setTitle(updatedArticle.getTitle());
                article.setContent(updatedArticle.getContent());
                article.setAuthor(updatedArticle.getAuthor());
                article.setUpdatedAt(LocalDateTime.now());
                return articleRepository.save(article);
            }).orElseThrow(() -> new RuntimeException("Article not found with id " + id));
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
