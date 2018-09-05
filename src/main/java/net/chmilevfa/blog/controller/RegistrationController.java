package net.chmilevfa.blog.controller;

import net.chmilevfa.blog.model.User;
import net.chmilevfa.blog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * TODO description
 *
 * @author chmilevfa
 * @since 01.09.18
 */
@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model) {

        model.addAttribute("user", new User());
        return "/registration";
    }

    @PostMapping("/registration")
    public String registerNewUser(@Valid User user,
                                BindingResult bindingResult,
                                Model model) {
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            bindingResult
                    .rejectValue("username", "error.user",
                            "There is already a user registered with the username provided");
        }

        if (!bindingResult.hasErrors()) {
            // Registration successful, save user
            userService.save(user);

            model.addAttribute("successMessage", "User has been registered successfully");
        }

        return "/registration";
    }
}
