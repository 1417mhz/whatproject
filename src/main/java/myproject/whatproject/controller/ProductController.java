package myproject.whatproject.controller;

import lombok.RequiredArgsConstructor;
import myproject.whatproject.domain.product.Product;
import myproject.whatproject.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/register")
    public String saveProductForm() {
        return "/product/saveNewProductForm";
    }

    @PostMapping("/register")
    public String saveProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/product/list";
    }

    @GetMapping("/list")
    public String listAllProduct(Model model) {
        List<Product> products = productService.listAllProduct();
        model.addAttribute("products", products);
        return "/product/products";
    }

    @GetMapping("/list/{productNo}")
    public String productInfo(@PathVariable String productNo, Model model) {
        Product product = productService.findProductByNo(productNo);
        model.addAttribute("product", product);
        return "/product/product";
    }

}
