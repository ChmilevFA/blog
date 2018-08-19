package net.chmilevfa.blog.controller;

import net.chmilevfa.blog.model.Article;
import net.chmilevfa.blog.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Controller responsible for properly creating new {@link Article}.
 *
 * @author chmilevfa
 * @since 19.08.18
 */
@Controller
public class NewArticleController {

    private final ArticleService articleService;

    public NewArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /** Returns UI form for creating new {@link Article}. */
    @GetMapping("/newArticle")
    public String getNewArticlePage(Model model) {
        Article newArticle = new Article();
        model.addAttribute("article", newArticle);
        return "/newArticle";
    }

    /** Handles with filled in {@link Article} from UI. */
    @PostMapping("/newArticle")
    public String saveNewArticle(@Valid Article newArticle) {
        articleService.save(newArticle);
        return "redirect:/";
    }
}
