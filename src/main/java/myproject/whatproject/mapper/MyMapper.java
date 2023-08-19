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

    User findUserByNo(int userNo);

    User findUserById(String userId);

    int findUserNoById(String userId);

    User findUserByEmail(String userEmail);

//    List<User> findUserBySpecification(UserFilterDto filter);

    String userVerify(String userId);

    void changeUserPw(@Param("userId") String userId, @Param("changePw") String changePw);


    /* 판매자 **/
    List<Seller> findAllSeller();

    Seller findSellerByNo(int sellerNo);


    /* 상품 **/
    void saveProduct(Product product);

    List<Product> listAllProduct();

    Product findProductByNo(int productNo);


    /* 주문 **/
    List<Purchase> findAllOrder();

    Purchase findOrderByNo(int purchaseNo);

    List<Purchase> findUserOrder(int userNo);

    void createNewOrder(Purchase purchase);

    void updateProductStock(@Param("productNo") int productNo, @Param("newProductStock") int newProductStock);

    void updateUserBalance(@Param("userNo") int userNo, @Param("newUserBalance") int newUserBalance);

    void cancelOrder(int purchaseNo);

    void restoreProductQuantity(@Param("restoreQuantity") int restoreQuantity, @Param("productNo") int productNo);

    void restoreUserBalance(@Param("restoreBalance") int restoreBalance, @Param("userNo") int userNo);

}
