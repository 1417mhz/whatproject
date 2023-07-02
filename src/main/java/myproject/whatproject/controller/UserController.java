package myproject.whatproject.controller;

import myproject.whatproject.domain.user.User;
import myproject.whatproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/member/register")
    public String saveNewUserForm() {
        // html 매핑
        return "/member/saveNewUserForm";
    }

    @PostMapping("/member/register")
    public String saveNewUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/member/pw-change")
    public String changeUserPwForm() {
        return "/member/changePwForm";
    }

    @PostMapping("/member/pw-change")
    public String changeUserPw(String userId, String inputPw, String changePw) {
        userService.changeUserPw(userId, inputPw, changePw);
        return "redirect:/";
    }

}
