package myproject.whatproject.domain.coupon;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Coupon {

    private int couponCode; // auto_increment
    private String couponName;
    private String description;
    private int issuer; // 회원
    private String issueDate; // timestamp
    private String expDate;

}
