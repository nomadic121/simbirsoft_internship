package org.nomadic121.chat.controller.View;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.nomadic121.chat.form.UserForm;
import org.nomadic121.chat.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserLoginController {

    private final @NonNull UserService userService;

    @GetMapping("/login")
    public String signInPage(@RequestParam(value = "error", required = false) String error, ModelMap model) {
        if (error != null) {
            model.addAttribute("error", "name or password not correct");
        } else {
            model.addAttribute("error", "");
        }
        return "login";
    }

    @GetMapping("/sign_up")
    public String signUpPage() {
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String signUp(@RequestParam(name = "username", required = true) String username,
                         @RequestParam(name = "password", required = true) String password) {
        UserForm userForm = new UserForm(username, password);
        userService.save(userForm);
        return "redirect:/chatList";
    }

}
