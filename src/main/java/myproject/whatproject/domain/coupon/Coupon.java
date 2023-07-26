package myproject.whatproject.domain.coupon;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Coupon {

    private String couponCode; // auto_increment
    private String name;
    private String description;
    private String issuer; // 회원
    private String issueDate; // timestamp
    private String expDate;

}
