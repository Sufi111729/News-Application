package com.sufi.app.repositories;

import com.sufi.app.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    // Optional custom methods:
    List<Article> findByAuthor(String author);
    List<Article> findByTitleContainingIgnoreCase(String keyword);
}

