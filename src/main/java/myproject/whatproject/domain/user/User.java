package myproject.whatproject.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter
@NoArgsConstructor
public class User {

    private String userNum; // auto_increment
    private String email;
    private String id;
    private String pw;
    private String name;
    private String contact;
    private String dob;
    private String gender;
    private String role;
    private int balance;
    private String state; // default = '활성'
    private String signupDate; // current_timestamp
    private String leaveDate; // current_timestamp

}
