package myproject.whatproject.service;

import myproject.whatproject.domain.user.User;
import myproject.whatproject.mapper.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final MyMapper myMapper;

    @Autowired
    public UserService(MyMapper myMapper) {
        this.myMapper = myMapper;
    }


    public void saveUser(User user) {
        myMapper.saveUser(user);
    }

    public List<User> findAllUser() {
        return myMapper.findAllUser();
    }

    public User findUserById(String userId) {
        return myMapper.findUserById(userId);
    }

    public boolean userVerify(String userId, String inputPw) {
        // form 으로 전달받은 유저의 현재 비밀번호와 db에 저장된 현재 비밀번호가 일치한지 확인
        return myMapper.userVerify(userId).equals(inputPw);
    }

    public void changeUserPw(String userId, String changePw) {
        myMapper.changeUserPw(userId, changePw);
    }

}
