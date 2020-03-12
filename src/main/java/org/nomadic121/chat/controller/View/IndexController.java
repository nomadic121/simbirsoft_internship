package org.nomadic121.chat.controller.View;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String signUpPage() {
        return "redirect:/chatList";
    }

}
