package net.chmilevfa.blog.service.impl;

import net.chmilevfa.blog.model.Article;
import net.chmilevfa.blog.repository.ArticleRepository;
import net.chmilevfa.blog.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link ArticleService} which uses {@link org.springframework.data.jpa.repository.JpaRepository}
 * for storing {@link Article} objects.
 *
 * @author chmilevfa
 * @since 19.08.18
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public Article save(Article article) {
        return articleRepository.saveAndFlush(article);
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.findAllByOrderByCreateDateTimeDesc();
    }

    @Override
    public Optional<Article> getById(@NotNull Long id) {
        return articleRepository.findById(id);
    }
}
