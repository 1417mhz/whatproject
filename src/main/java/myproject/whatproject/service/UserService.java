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

    public List<User> findAllUser() {
        return myMapper.findAllUsers();
    }

    public void saveUser(User user) {
        myMapper.saveUser(user);
    }

}
