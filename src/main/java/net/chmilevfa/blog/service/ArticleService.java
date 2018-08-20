package net.chmilevfa.blog.service;

import net.chmilevfa.blog.model.Article;

import java.util.List;

/**
 * Describes services for handling with {@link Article}.
 *
 * @author chmilevfa
 * @since 19.08.18
 */
public interface ArticleService {

    /** Saves new {@link Article}. */
    Article save(Article article);

    /** Returns all {@link Article} sorted by creation by desc. */
    List<Article> getAll();
}
