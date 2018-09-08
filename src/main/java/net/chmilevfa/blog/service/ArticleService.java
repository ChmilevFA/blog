package net.chmilevfa.blog.service;

import net.chmilevfa.blog.model.Article;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Describes service for handling with {@link Article}.
 *
 * @author chmilevfa
 * @since 19.08.18
 */
public interface ArticleService {

    /** Saves new {@link Article}. */
    Article save(Article article);

    /** Returns all {@link Article} sorted by creation by desc. */
    List<Article> getAll();

    /** Returns {@link Optional} for {@link Article} class by identifier. */
    Optional<Article> getById(@NotNull Long id);
}
