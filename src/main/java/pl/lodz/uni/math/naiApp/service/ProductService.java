package pl.lodz.uni.math.naiApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.uni.math.naiApp.domain.Product;
import pl.lodz.uni.math.naiApp.pl.lodz.uni.math.naiApp.mapper.ProductMapper;

import java.util.List;

/**
 * Created by HP on 2018-04-19.
 */
@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;

    public List<Product> getAllProducts() {
        return productMapper.getAllProducts();
    }
}
