package pl.lodz.uni.math.naiApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.lodz.uni.math.naiApp.domain.Product;
import pl.lodz.uni.math.naiApp.service.ProductService;

import java.util.List;

/**
 * Created by HP on 2018-04-19.
 */
@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/product")
    @ResponseBody
    public List<Product> selectAllProducts() {
        return productService.getAllProducts();
    }
}
