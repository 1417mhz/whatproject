package myproject.whatproject.mapper;

import myproject.whatproject.domain.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MyMapper {

    void saveUser(User user);

    List<User> findAllUser();

    User findUserById(String userId);

    User findUserByEmail(String userEmail);

    String userVerify(String userId);

    // 인자를 두 개 이상 전달 시 mapper 에서 인자 이름을 인식할 수 있도록 직접 이름을 지정
    void changeUserPw(@Param("userId") String userId, @Param("changePw") String changePw);

}
