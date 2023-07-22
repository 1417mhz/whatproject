package myproject.whatproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myproject.whatproject.domain.product.Product;
import myproject.whatproject.domain.user.User;
import myproject.whatproject.mapper.MyMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final MyMapper myMapper;
    private final PasswordEncoder pwEncoder;

    // 회원 저장 메소드
    public void saveUser(User user) {
        // 회원 정보 중복 여부를 입력된 id와 email로 확인
        if (userDuplicateValidation(user.getId(), user.getEmail())) {
            // 비밀번호 암호화 후 저장 로직 수행
            user.setPw(pwEncoder.encode(user.getPw()));
            myMapper.saveUser(user);
            log.info("** 회원가입 완료 **");
        } else {
            log.error("!! 이미 존재하는 회원입니다 !!");
        }
    }

    // 회원 정보 중복 여부 확인 메소드
    public boolean userDuplicateValidation(String userId, String userEmail) {
        // 쿼리를 한 번 만 보내는 방법은 없을까
        return findUserById(userId) == null && findUserByEmail(userEmail) == null;
        // 중복되는 회원 정보가 없으면 true 반환
    }

    // 회원 전체 조회 메소드
    public List<User> findAllUser() {
        return myMapper.findAllUser();
    }

    // 회원 등록번호를 통한 조회 메소드
    public User findUserByNum(String user_no) {
        return myMapper.findUserByNum(user_no);
    }

    // 회원 ID를 통한 조회 메소드
    public User findUserById(String userId) {
        return myMapper.findUserById(userId);
    }

    // 회원 이메일을 통한 조회 메소드
    public User findUserByEmail(String userEmail) {
        return myMapper.findUserByEmail(userEmail);
    }

    // 회원 중복 여부 확인 메소드
    public boolean userVerify(String userId, String inputPw) {
        // form 으로 전달받은 유저의 현재 비밀번호와 db에 저장된 현재 비밀번호(암호화 됨)가 일치한지 확인
        return pwEncoder.matches(inputPw, myMapper.userVerify(userId));
    }

    // 회원 비밀번호 변경 메소드
    public void changeUserPw(String userId, String inputPw, String changePw) {
        // 입력된 비밀번호와 db에 있는 암호화 된 비밀번호가 서로 일치한지 확인
        if (userVerify(userId, inputPw)) {
            myMapper.changeUserPw(userId, pwEncoder.encode(changePw)); // 일치할 경우 변경 작업 수행
            log.info("** 사용자 비밀번호 변경 완료 **");
        } else {
            log.error("!! 사용자 비밀번호 변경 실패 !!");
        }
    }
}
