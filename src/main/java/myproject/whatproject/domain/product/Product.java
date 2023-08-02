package myproject.whatproject.domain.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Product {

    private String productNo; // auto_increment
    private String name;
    private int price;
    private String description;
    private int quantity;
    private String regDate; // timestamp
    private String state; // default = '활성'
    private String seller;
    private String category;

}
