package myproject.whatproject.service;

import myproject.whatproject.domain.user.User;
import myproject.whatproject.mapper.MyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired MyMapper myMapper;
    @Autowired UserService userService;
    @Autowired PasswordEncoder pwEncoder;

    /*
    @Test
    void findUserByIdTest() {
        String userId = "ysww";
        User user = myMapper.findUserById(userId);
        assertThat(user.getId()).isEqualTo(userId);
    }

    @Test
    void userVerifyTest() {
        String userId = "ysww";
        String inputPw = "0987";

        String userPw = myMapper.userVerify(userId);
        assertThat(userPw).isEqualTo(inputPw);
    }

    @Test
    void userPwChangeTest() {
        String userId = "ysww";
        String inputPw = "1234";
        String changePw = "0987";

        if (myMapper.userVerify(userId).equals(inputPw)) {
            myMapper.changeUserPw(userId, changePw);
        }
        User user = myMapper.findUserById(userId);
        assertThat(user.getPw()).isEqualTo(changePw);
        System.out.println("변경된 비밀번호 = " + user.getPw());
    }
    **/

    @Test
    void userPwChangeTest2() {
        String userId = "b12345";
        String inputPw = "123456";
        String changePw = "987654";

        userService.changeUserPw(userId, inputPw, changePw);
        assertThat(pwEncoder.matches(changePw, myMapper.userVerify(userId))).isTrue();
    }

    @Test
    void userDuplicateValidateTest() {
        String userId1 = "qwerasdf";
        String userEmail1 = "12345@gmail.com";
        String userId2 = "ysww";
        String userEmail2 = "54321@gmail.com";

        boolean validation1 = userService.userDuplicateValidation(userId1, userEmail1);
        boolean validation2 = userService.userDuplicateValidation(userId2, userEmail2);
        assertThat(validation1).isTrue();
        assertThat(validation2).isFalse();
    }

}
