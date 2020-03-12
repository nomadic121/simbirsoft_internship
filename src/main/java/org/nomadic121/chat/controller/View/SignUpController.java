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
public class SignUpController {

    private final @NonNull UserService userService;

    @GetMapping("/sign_up")
    public String signUpPage(@RequestParam(value = "msg", required = false) String msg,
                             ModelMap model) {
        if (msg != null) {
            model.addAttribute("msg", msg);
        } else {
            model.addAttribute("msg", "");
        }
        return "sign_up";
    }

    @PostMapping("/sign_up")
    public String signUp(@RequestParam(name = "username", required = true) String username,
                         @RequestParam(name = "password", required = true) String password,
                         ModelMap model) {
        if (!username.isEmpty() && !password.isEmpty()) {
            UserForm userForm = new UserForm(username, password);
            userService.createAndSave(userForm);
            return "redirect:/chatList";
        }
        model.addAttribute("msg", "name or password not correct");
        return "sign_up";
    }

}
