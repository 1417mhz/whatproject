package myproject.whatproject.mapper;

import myproject.whatproject.domain.product.Product;
import myproject.whatproject.domain.purchase.Purchase;
import myproject.whatproject.domain.seller.Seller;
import myproject.whatproject.domain.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MyMapper {
    /* 사용자 **/
    void saveUser(User user);

    List<User> findAllUser();

    User findUserByNum(String userNum);

    User findUserById(String userId);

    User findUserByEmail(String userEmail);

    String userVerify(String userId);

    // 인자를 두 개 이상 전달 시 mapper 에서 인자 이름을 인식할 수 있도록 직접 이름을 지정
    void changeUserPw(@Param("userId") String userId, @Param("changePw") String changePw);

    /* 판매자 **/
    List<Seller> findAllSeller();

    Seller findSellerByNum(String sellerNum);


    /* 상품 **/
    void saveProduct(Product product);

    List<Product> listAllProduct();

    Product findProductByNum(String productNum);

    /* 주문 **/
    List<Purchase> findAllOrder();

    void createNewOrder(Purchase purchase);

    void updateProductQuantity(@Param("productNum") String productNum, @Param("quantity") String orderQuantity);

    void updateUserBalance(@Param("userNum") String userNum, @Param("balance") String balance);

}
