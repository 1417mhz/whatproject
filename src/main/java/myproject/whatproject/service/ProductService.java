package myproject.whatproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import myproject.whatproject.domain.product.Product;
import myproject.whatproject.mapper.MyMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final MyMapper myMapper;

    public void saveProduct(Product product) {
        if (myMapper.findSellerByNum(product.getSeller()) != null) {
            myMapper.saveProduct(product);
            log.info("** 상품 등록 완료 **");
        } else {
            log.error("!! 해당 판매자는 등록되어있지 않습니다 !!");
        }
    }

    public List<Product> listAllProduct() {
        return myMapper.listAllProduct();
    }

    public Product findProductByNum(String product_no) {
        return myMapper.findProductByNum(product_no);
    }

}
