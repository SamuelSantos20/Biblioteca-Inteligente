package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    /**
     * Exibe a página inicial.
     * @return ModelAndView para a página index.
     */
    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index.html");
        return mv;
    }
}
