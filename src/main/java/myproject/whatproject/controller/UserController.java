package myproject.whatproject.controller;

import lombok.RequiredArgsConstructor;
import myproject.whatproject.domain.user.User;
import myproject.whatproject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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
    @GetMapping("/list/{user_no}")
    public String userInfo(@PathVariable String user_no, Model model) {
        User user = userService.findUserByNum(user_no);
        model.addAttribute("user", user);
        return "/user/user";
    }

    // 회원 비밀번호 변경 폼 매핑
    @GetMapping("/pw-change")
    public String changeUserPwForm(Principal principal, Model model) {
        model.addAttribute("userId", principal.getName());
        return "/user/changePwForm";
    }

    // 회원 비밀번호 변경 요청 매핑
    @PostMapping("/pw-change")
    public String changeUserPw(String userId, String inputPw, String changePw) {
        userService.changeUserPw(userId, inputPw, changePw);
        return "redirect:/";
    }

    // 로그인 폼 요청 매핑
    @GetMapping("/login")
    public String loginUserForm() {
        return "/user/userLoginForm";
    }

    // 마이페이지 요청 매핑
    @GetMapping("/my-page")
    public String myPage(Principal principal, Model model) { // 로그인 된 유저의 정보를 가져와 쿼리 조회
        String userId = principal.getName();
        User user = userService.findUserById(userId);
        model.addAttribute("user", user);
        return "/user/my-page";
    }

}
