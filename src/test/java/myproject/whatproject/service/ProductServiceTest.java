package myproject.whatproject.service;

import myproject.whatproject.domain.product.Product;
import myproject.whatproject.mapper.MyMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class ProductServiceTest {

    @Autowired MyMapper myMapper;
    @Autowired ProductService productService;

    @Test
    void listAllProductTest() {
        Product product = new Product();
        product.setName("에어컨");
        product.setProduct_no("800000");
        product.setDescription("2023년식 신형 에어컨");
        product.setQuantity("10");
        product.setSeller("3");
        product.setCategory("전자제품");
        productService.saveProduct(product);

        List<Product> products = productService.listAllProduct();
        Assertions.assertThat(products).hasSize(2);
    }

    @Test
    void saveNewProductTest() {
        Product product = new Product();
        product.setName("좋은거");
        product.setPrice("50000");
        product.setDescription("좋은거");
        product.setQuantity("5");
        product.setSeller("2"); // 등록되어있는 판매자
        product.setCategory("전자제품");

        productService.saveProduct(product);
    }

}
