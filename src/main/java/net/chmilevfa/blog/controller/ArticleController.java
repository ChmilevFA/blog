package net.chmilevfa.blog.controller;

import net.chmilevfa.blog.model.Article;
import net.chmilevfa.blog.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * Controller for particular {@link Article}.
 *
 * @author chmilevfa
 * @since 20.08.18
 */
@Controller
public class ArticleController {

    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/article/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
        Optional<Article> result = articleService.getById(id);
        if (result.isPresent()) {
            model.addAttribute("article", result.get());
            return "/article";
        }
        return "/error";
    }
}
