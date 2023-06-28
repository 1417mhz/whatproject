package myproject.whatproject.domain.user;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class User {

    private String user_no; // auto_increment
    private String email;
    private String id;
    private String pw;
    private String name;
    private String contact;
    private String dob;
    private String gender;
    private String grade;
    private String state; // default = '활성'

    public User () {}

    public User (String email, String id, String pw, String name, String contact, String dob, String gender, String grade) {
        this.email = email;
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.contact = contact;
        this.dob = dob;
        this.gender = gender;
        this.grade = grade;
    }

}
