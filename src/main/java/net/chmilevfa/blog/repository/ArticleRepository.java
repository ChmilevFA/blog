package net.chmilevfa.blog.repository;

import net.chmilevfa.blog.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Extends standard {@link JpaRepository} for handling with {@link Article}.
 *
 * @author chmilevfa
 * @since 19.08.18
 */
public interface ArticleRepository extends JpaRepository <Article, Long> {

    /** Retrieves all {@link Article} from repository ordered by {@link Article#createDateTime} by DESC. */
    List<Article> findAllByOrderByCreateDateTimeDesc();
}
