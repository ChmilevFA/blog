package net.chmilevfa.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * Handler for any server errors.
 *
 * @author chmilevfa
 * @since 22.08.18
 */
@Controller
public class ErrorsController implements ErrorController {

    private static Logger logger = LoggerFactory.getLogger(ErrorsController.class);

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            logger.error("Error during execution of application, status code is {}", statusCode);
        } else {
            logger.error("Error during execution of application, status code is unknown");
        }
        return "/error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
