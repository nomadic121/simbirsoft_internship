package org.nomadic121.chat.controller.View;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final @NonNull UserService userService;

    @GetMapping("/login")
    public String signInPage(@RequestParam(value = "error", required = false) String error,
                             ModelMap model) {
        if (error != null) {
            model.addAttribute("error", "name or password not correct");
        } else {
            model.addAttribute("error", "");
        }
        return "login";
    }

}
