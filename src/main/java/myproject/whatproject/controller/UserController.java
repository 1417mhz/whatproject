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

    @GetMapping("/member/list-api")
    @ResponseBody
    public List<User> findAll() {
        return userService.findAllUser();
    }

    @GetMapping("/member/register")
    public String saveNewUserForm() {
        // html 매핑
        return "/member/saveNewUserForm";
    }

    @RequestMapping("/member/register")
    public String saveNewUser(HttpServletRequest req) {

        User user = new User();
        user.setEmail(req.getParameter("email"));
        user.setId(req.getParameter("id"));
        user.setPw(req.getParameter("pw"));
        user.setName(req.getParameter("name"));
        user.setContact(req.getParameter("contact"));
        user.setDob(req.getParameter("dob"));
        user.setGender(req.getParameter("gender"));
        user.setGrade(req.getParameter("grade"));

        userService.saveUser(user);

        System.out.println("** 신규 회원 저장 완료 **");

        return "redirect:/";
    }

}
