package myproject.whatproject.domain.purchase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ShipAddress {

    private String ship_no; // auto_increment
    private String user; // FK user(user_no)
    private String address;
    private String post_code; // 생략 가능
    private String contact;

}