package pl.lodz.uni.math.naiApp.domain;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by HP on 2018-06-04.
 */
public class Order {
    private int id;
    private LocalDate orderDate;
    private List<Product> productList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
