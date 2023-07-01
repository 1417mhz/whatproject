package myproject.whatproject.controller;

import myproject.whatproject.domain.user.User;
import myproject.whatproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserApiController {
    // view 반환 컨트롤러와 데이터 반환 컨트롤러 분리

    private final UserService userService;

    @Autowired
    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/member/list-api")
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

}
