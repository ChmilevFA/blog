package net.chmilevfa.blog.service;

import net.chmilevfa.blog.model.Article;

/**
 * Describes services for handling with {@link Article}.
 *
 * @author chmilevfa
 * @since 19.08.18
 */
public interface ArticleService {

    /** Saves new {@link Article}. */
    Article save(Article article);
}
