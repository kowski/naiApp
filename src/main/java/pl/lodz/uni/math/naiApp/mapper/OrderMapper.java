package pl.lodz.uni.math.naiApp.mapper;

import org.apache.ibatis.annotations.*;
import pl.lodz.uni.math.naiApp.domain.Order;
import pl.lodz.uni.math.naiApp.domain.Product;
import pl.lodz.uni.math.naiApp.domain.Supplier;

import java.util.List;

/**
 * Created by HP on 2018-06-05.
 */
@Mapper
public interface OrderMapper {
    @Select("SELECT id,order_date from orders")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "orderDate", column = "order_date"),
            @Result(property = "productList", column = "id", javaType = List.class, many = @Many(select = "getProducts"))
    })
    List<Order> getAllOrders();

    @Select("SELECT product_id, product.code, product.product_code, product.name, product.body,product.supplier_id FROM order_product join product on product.id=product_id WHERE order_id=#{orderId}")
    @Results(value = {
            @Result(property = "id", column = "product_id"),
            @Result(property = "code", column = "code"),
            @Result(property = "product_code", column = "product_code"),
            @Result(property = "name", column = "name"),
            @Result(property = "body", column = "body"),
            @Result(property = "supplier", column = "supplier_id", one = @One(select = "getSupplier"))
    })
    List<Product> getProducts(Integer orderId);

    @Select("Select id, company_name,contact_number, city from supplier where id=#{id}")
    Supplier getSupplier(Integer id);

    @Select("Select count(*) FROM orders")
    Integer getOrderCount();
}
