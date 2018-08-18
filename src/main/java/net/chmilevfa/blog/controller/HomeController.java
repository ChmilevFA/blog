package net.chmilevfa.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for main (home) page.
 *
 * @author chmilevfa
 * @since 18.08.18
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("test", "text for test");
        return "/home";
    }

}
