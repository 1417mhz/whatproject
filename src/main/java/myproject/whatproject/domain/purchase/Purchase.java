package myproject.whatproject.domain.purchase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Purchase {

    private String purchaseNum; // auto_increment
    private String productNum; // FK product(product_no)
    private int price;
    private int quantity;
    private String purchaseDate; // timestamp
    private String buyer; // FK user(user_no)
    // private String shipAddress;
    // private String postCode;
    private String contact;
    // private String shipCo; // FK ship_co(code)
    private String seller; // FK seller(seller_no)
    private String state;
    private String stateUpdate; // timestamp

}
