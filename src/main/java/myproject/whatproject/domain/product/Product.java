package myproject.whatproject.domain.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Product {

    private String product_no; // auto_increment
    private String name;
    private String price;
    private String description;
    private String quantity;
    private String reg_date; // timestamp
    private String state; // default = '활성'
    private String seller;
    private String category;

}
