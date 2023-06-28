package myproject.whatproject.service;

import myproject.whatproject.domain.user.User;
import myproject.whatproject.mapper.MyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired MyMapper myMapper;

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

}
