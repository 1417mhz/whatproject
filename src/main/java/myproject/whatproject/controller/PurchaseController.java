package myproject.whatproject.controller;

import lombok.RequiredArgsConstructor;
import myproject.whatproject.domain.purchase.ProductToPurchaseVO;
import myproject.whatproject.domain.purchase.Purchase;
import myproject.whatproject.service.PurchaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @GetMapping("/new")
    public String createNewOrderForm(ProductToPurchaseVO orderInfo, Principal principal, Model model) {
        model.addAttribute("user", purchaseService.getUserInstance(principal.getName())); // 로그인 되어있는 유저
        model.addAttribute("product", purchaseService.getProductInstance(orderInfo.getProductNo()));
        model.addAttribute("orderInfo", orderInfo);
        model.addAttribute("totalCheckout", orderInfo.getPrice() * orderInfo.getOrderQuantity()); // 총 결제 금액
        return "/purchase/createNewOrderForm";
    }

    @PostMapping("/new")
    public String createNewOrder(Purchase purchase) {
        purchaseService.createNewOrder(purchase);
        return "redirect:/";
    }

    @PostMapping("/cancel")
    public String cancelOrder(int purchaseNo) {
        purchaseService.cancelOrder(purchaseNo);
        return "redirect:/order/list";
    }

    @GetMapping("/list")
    public String redirectToOrderList(Principal principal) {
        int userNo = purchaseService.getUserInstance(principal.getName()).getUserNo();
        return "redirect:/order/list/user/" + userNo;
    }

    @GetMapping("/list/all") // 어드민페이지
    public String getOrderList(Model model) {
        List<Purchase> orders = purchaseService.findAllOrder();
        model.addAttribute("orders", orders);
        return "/purchase/orders";
    }

    @GetMapping("/list/{purchaseNo}")
    public String getOrderInfo(@PathVariable int purchaseNo, Model model) {
        Purchase order = purchaseService.findOrderByNo(purchaseNo);
        model.addAttribute("order", order);
        return "/purchase/order";
    }

    @GetMapping("/list/user/{userNo}")
    public String getUserOrderList(@PathVariable int userNo, Model model) {
        List<Purchase> orders = purchaseService.findUserOrder(userNo);
        model.addAttribute("orders", orders);
        return "/purchase/orders";
    }

}
