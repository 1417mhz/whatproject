package myproject.whatproject.domain.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Product {

    private int productNo; // auto_increment
    private String productName;
    private int price;
    private String description;
    private int productStock; // 변경 전 quantity
    private String regDate; // timestamp
    private String state; // default = '활성'
    private int sellerNo;
    private String category;

}
