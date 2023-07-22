package myproject.whatproject.controller;

import lombok.RequiredArgsConstructor;
import myproject.whatproject.domain.seller.Seller;
import myproject.whatproject.service.SellerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @GetMapping("/list")
    public String findAllSellerForm(Model model) {
        List<Seller> sellers = sellerService.findAllSeller();
        model.addAttribute("sellers", sellers);
        return "/seller/sellers";
    }
}
