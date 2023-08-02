package myproject.whatproject.domain.purchase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ShipAddress {

    private int shipNo; // auto_increment
    private int user; // FK user(user_no)
    private String address;
    private int postCode; // 생략 가능
    private String contact;

}
