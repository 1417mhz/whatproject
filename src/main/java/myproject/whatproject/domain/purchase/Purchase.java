package myproject.whatproject.domain.purchase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Purchase {

    private int purchaseNo; // auto_increment
    private int productNo; // FK product(product_no)
    private int price;
    private int orderQuantity;
    private int totalCheckout;
    private String purchaseDate; // timestamp
    private int buyer; // FK user(user_no)
    private String buyerId; // 회원 아이디를 통해 회원 등록번호를 알아오기 위한 속성
    // private String shipAddress;
    // private String postCode;
    private String contact;
    // private String shipCo; // FK ship_co(code)
    private int sellerNo; // FK seller(seller_no)
    private String state;
    private String stateUpdate; // timestamp

}
