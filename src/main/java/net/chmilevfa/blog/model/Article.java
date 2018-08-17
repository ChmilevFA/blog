package net.chmilevfa.blog.model;

import java.time.LocalDateTime;

/**
 * Describes entity of blog's article.
 *
 * @author chmilevfa
 * @since 17.08.18
 */
public final class Article {

    private Long id;

    private String title;

    private String body;

    private LocalDateTime dateTime;

    public Article(Long id, String title, String body, LocalDateTime dateTime) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
