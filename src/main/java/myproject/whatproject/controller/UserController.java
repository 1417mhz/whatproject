package myproject.whatproject.controller;

import myproject.whatproject.domain.user.User;
import myproject.whatproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

        System.out.println("** 신규 회원 저장 완료 **");

        return "redirect:/";
    }

    @GetMapping("/member/list-api")
    @ResponseBody
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    @GetMapping("/member/pw-change")
    public String changeUserPwForm() {
        return "/member/changePwForm";
    }

    @PostMapping("/member/pw-change")
    public String changeUserPw(String userId, String inputPw, String changePw) {
        if (userService.userVerify(userId, inputPw)) { // 입력된 비밀번호와 db에 있는 비밀번호가 일치한지 확인
            userService.changeUserPw(userId, changePw); // 일치할 경우 변경 작업 수행
            System.out.println("** 사용자 비밀번호 변경 완료 **");
        } else {
            System.out.println("!! 사용자 비밀번호 변경 실패 !!");
        }
        return "redirect:/";
    }

}
