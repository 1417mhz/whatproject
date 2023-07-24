package myproject.whatproject.controller;

import lombok.RequiredArgsConstructor;
import myproject.whatproject.domain.purchase.Purchase;
import myproject.whatproject.service.PurchaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseService purchaseService;

    @GetMapping("/new")
    public String createNewOrderForm() {
        return "/purchase/createNewOrderForm";
    }
    // 상품 정보에서 주문을 클릭했을 때 상품의 정보를 어떻게 넘겨 결제를 발생시킬지 생각해보셈

    @PostMapping("/new")
    public String createNewOrder(Purchase purchase) {
        purchaseService.createNewOrder(purchase);
        return "redirect:/";
    }

}
