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
        purchase.setProduct_no("8");
        purchase.setQuantity(2);
        purchase.setBuyer("13");
        purchase.setContact("010-8888-9999");
        purchase.setSeller("1");

        purchaseService.createNewOrder(purchase);

        List<Purchase> orders = purchaseService.findAllOrder();
        Product product = myMapper.findProductByNum(purchase.getProduct_no());
        Assertions.assertThat(orders).hasSize(1);
        System.out.println(product.getQuantity());
    }

}