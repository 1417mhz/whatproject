package myproject.whatproject.domain.seller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Seller {

    private String seller_no; // auto_increment
    private String user_no; // 등록된 회원은 판매자가 될 수 있다
    private String contact;
    private String state;

}
