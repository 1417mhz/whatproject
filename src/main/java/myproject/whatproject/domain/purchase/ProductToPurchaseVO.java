package myproject.whatproject.domain.purchase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ProductToPurchaseVO {
    // 상품 정보 페이지에서 주문 생성 페이지로 넘길 정보
    private int productNo; // 상품 등록번호
    private int price; // 상품 가격
    private int orderQuantity; // 주문 수량

}
