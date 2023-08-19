package myproject.whatproject.service;

import myproject.whatproject.domain.product.Product;
import myproject.whatproject.domain.purchase.Purchase;
import myproject.whatproject.mapper.MyMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PurchaseServiceTest {

    @Autowired MyMapper myMapper;
    @Autowired PurchaseService purchaseService;

    @Test
    void createNewOrderTest() {
        Purchase purchase = new Purchase();
        purchase.setProductNo(8);
        purchase.setOrderQuantity(2);
        purchase.setBuyer(13);
        purchase.setContact("010-8888-9999");
        purchase.setSellerNo(1);

        purchaseService.createNewOrder(purchase);

        List<Purchase> orders = purchaseService.findAllOrder();
        Product product = myMapper.findProductByNo(purchase.getProductNo());
        Assertions.assertThat(orders).hasSize(1);
        System.out.println(product.getProductStock());
    }

}