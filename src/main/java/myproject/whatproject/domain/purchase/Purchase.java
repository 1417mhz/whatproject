package myproject.whatproject.domain.purchase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Purchase {

    private String purchase_no; // auto_increment
    private String product_no; // FK product(product_no)
    private String purchase_date; // timestamp
    private String buyer; // FK user(user_no)
    private String ship_address;
    private String post_code;
    private String contact;
    private String ship_co; // FK ship_co(name)
    private String state;
    private String state_update; // timestamp

}
