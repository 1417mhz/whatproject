package myproject.whatproject.domain.coupon;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserCoupon {

    private String issue_code; // auto_increment
    private String cp_code; // FK coupon(coupon_no)
    private String user_no; // FK user(user_no)
    private String cp_state;

}
