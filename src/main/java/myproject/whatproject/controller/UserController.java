package myproject.whatproject.controller;

import lombok.RequiredArgsConstructor;
import myproject.whatproject.domain.user.User;
import myproject.whatproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 회원가입 폼 매핑
    @GetMapping("/register")
    public String saveNewUserForm() {
        return "/user/saveNewUserForm";
    }

    // 회원 가입 요청 매핑
    @PostMapping("/register")
    public String saveNewUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    // 회원 전체 조회 요청 매핑
    @GetMapping("/list")
    public String findAllUser(Model model) {
        List<User> users = userService.findAllUser();
        model.addAttribute("users", users);
        return "/user/users";
    }

    // 회원 세부 정보 조회 요청 매핑
    @GetMapping("/list/{id}")
    public String userInfo(@PathVariable String id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "/user/user";
    }

    // 회원 비밀번호 변경 폼 매핑
    @GetMapping("/pw-change")
    public String changeUserPwForm() {
        return "/user/changePwForm";
    }

    // 회원 비밀번호 변경 요청 매핑
    @PostMapping("/pw-change")
    public String changeUserPw(String userId, String inputPw, String changePw) {
        userService.changeUserPw(userId, inputPw, changePw);
        return "redirect:/";
    }

}
