package myproject.whatproject.mapper;

import myproject.whatproject.domain.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MyMapper {

    List<User> findAllUsers();

    void saveUser(User user);

}
