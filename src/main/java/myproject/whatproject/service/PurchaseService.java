package myproject.whatproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myproject.whatproject.domain.product.Product;
import myproject.whatproject.domain.purchase.Purchase;
import myproject.whatproject.domain.user.User;
import myproject.whatproject.mapper.MyMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PurchaseService {

    private final MyMapper myMapper;

    public List<Purchase> findAllOrder() {
        return myMapper.findAllOrder();
    }

    @Transactional
    public void createNewOrder(Purchase purchase) throws RuntimeException {
        int orderQuantity = purchase.getQuantity(); // 주문 수량
        int totalCheckout = purchase.getPrice() * orderQuantity; // 총 금액

        // 상품 데이터, 구매자(회원) 데이터 유효성 검증
        Product product = myMapper.findProductByNum(purchase.getProduct_no());
        User buyer = myMapper.findUserByNum(purchase.getBuyer());
        if (product == null || buyer == null) {
            log.error("!! 입력된 정보에 해당하는 데이터가 없습니다 !!");
            throw new RuntimeException();
        }

        // 재고 유효성 검증
        int newQuantity = product.getQuantity() - orderQuantity;
        if (newQuantity < 0) {
            log.error("!! 주문 등록 실패 !! 재고와 주문 수량을 확인해주세요");
            throw new RuntimeException("!! 주문 수량보다 재고가 적음 !!");
        }
        myMapper.updateProductQuantity(purchase.getProduct_no(), Integer.toString(newQuantity));

        // 적립금 유효성 검증
        int newUserBalance = buyer.getBalance() - totalCheckout;
        if (newUserBalance < 0) {
            log.error("!! 주문 등록 실패 !! 적립금이 부족합니다");
            throw new RuntimeException("!! 주문 금액보다 적립금이 적음 !!");
        }
        myMapper.updateUserBalance(buyer.getUser_no(), Integer.toString(newUserBalance));

        // 주문 성공
        myMapper.createNewOrder(purchase);

        log.info("** 주문 생성 완료 **");
    }
}