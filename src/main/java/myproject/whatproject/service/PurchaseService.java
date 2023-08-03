package myproject.whatproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myproject.whatproject.domain.product.Product;
import myproject.whatproject.domain.purchase.Purchase;
import myproject.whatproject.domain.user.User;
import myproject.whatproject.exception.*;
import myproject.whatproject.mapper.MyMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PurchaseService {

    private final MyMapper myMapper;
    private final UserService userService;
    private final ProductService productService;

    public List<Purchase> findAllOrder() {
        return myMapper.findAllOrder();
    }

    public Purchase findOrderByNo(int purchaseNo) {
        return myMapper.findOrderByNo(purchaseNo);
    }

    public List<Purchase> findUserOrder(int userNo) {
        return myMapper.findUserOrder(userNo);
    }

    public User getUserInstance(String userId) {
        return userService.findUserById(userId);
    }

    public Product getProductInstance(int productNo) {
        return productService.findProductByNo(productNo);
    }

    @Transactional
    public void createNewOrder(Purchase purchase) throws RuntimeException {
        Product product = myMapper.findProductByNo(purchase.getProductNo());
        User buyer = myMapper.findUserById(purchase.getBuyerId());

        // 상품 데이터, 구매자(회원) 데이터 유효성 검증
        if (product == null) {
            log.error("!! 입력된 정보에 해당하는 상품이 없습니다 !!");
            throw new ProductDataNotFoundException();
        }
        if (buyer == null) {
            log.error("!! 입력된 정보에 해당하는 회원이 없습니다 !!");
            throw new UserDataNotFoundException();
        }
        purchase.setBuyer(buyer.getUserNo()); // form에서 넘어온 사용자 id로 사용자 번호를 알아내서 set함
        int orderQuantity = purchase.getOrderQuantity(); // 주문 수량
        int totalCheckout = purchase.getOrderQuantity() * product.getPrice(); // 총 결제 금액

        int newProductStock = product.getProductStock() - orderQuantity;
        int newUserBalance = buyer.getBalance() - totalCheckout;

        // 재고 유효성 검증
        if (newProductStock < 0) {
            log.error("!! 주문 등록 실패 !! 재고와 주문 수량을 확인해주세요");
            throw new ProductStockNotEnoughException();
        }

        // 적립금 유효성 검증
        if (newUserBalance < 0) {
            log.error("!! 주문 등록 실패 !! 적립금이 부족합니다");
            throw new UserBalanceNotEnoughException();
        }

        // 주문 성공
        myMapper.createNewOrder(purchase);
        myMapper.updateProductStock(product.getProductNo(), newProductStock);
        myMapper.updateUserBalance(buyer.getUserNo(), newUserBalance);

        log.info("** 주문 생성 완료 **");
    }

    @Transactional
    public void cancelOrder(int purchaseNo) {
        Purchase order = myMapper.findOrderByNo(purchaseNo);
        if (order == null) {
            log.error("!! 입력된 정보에 해당하는 구매 내역이 없습니다 !!");
            throw new PurchaseDataNotFoundException();
        }

        User user = myMapper.findUserByNo(order.getBuyer());
        Product product = myMapper.findProductByNo(order.getProductNo());

        if (user == null) {
            log.error("!! 입력된 정보에 해당하는 회원이 없습니다 !!");
            throw new UserDataNotFoundException();
        }
        if (product == null) {
            log.error("!! 입력된 정보에 해당하는 상품이 없습니다 !!");
            throw new ProductDataNotFoundException();
        }

        int restoreBalance = user.getBalance() + order.getTotalCheckout();
        int restoreQuantity = product.getProductStock() + order.getOrderQuantity();

        myMapper.cancelOrder(purchaseNo);
        myMapper.restoreUserBalance(restoreBalance, user.getUserNo());
        myMapper.restoreProductQuantity(restoreQuantity, product.getProductNo());

        log.info("** 주문 취소 완료 **");
    }
}
