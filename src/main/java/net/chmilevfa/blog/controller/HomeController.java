package net.chmilevfa.blog.controller;

import net.chmilevfa.blog.model.Article;
import net.chmilevfa.blog.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Controller for main (home) page.
 *
 * @author chmilevfa
 * @since 18.08.18
 */
@Controller
public class HomeController {

    private final ArticleService articleService;

    public HomeController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String getHome(Model model) {
        List<Article> articles = articleService.getAll();
        model.addAttribute("articles", articles);
        return "/home";
    }

}
