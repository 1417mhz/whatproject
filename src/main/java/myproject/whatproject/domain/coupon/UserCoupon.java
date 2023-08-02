package myproject.whatproject.domain.coupon;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserCoupon {

    private String issueCode; // auto_increment
    private String couponCode; // FK coupon(coupon_no)
    private String userNo; // FK user(user_no)
    private String couponState;

}
