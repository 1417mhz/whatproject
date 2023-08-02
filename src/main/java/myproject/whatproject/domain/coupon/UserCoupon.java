package myproject.whatproject.domain.coupon;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserCoupon {

    private int issueCode; // auto_increment
    private int couponCode; // FK coupon(coupon_no)
    private int userNo; // FK user(user_no)
    private String couponState;

}
