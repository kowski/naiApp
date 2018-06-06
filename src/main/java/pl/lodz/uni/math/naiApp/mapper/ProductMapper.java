package pl.lodz.uni.math.naiApp.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.data.domain.DomainEvents;
import pl.lodz.uni.math.naiApp.domain.Product;
import pl.lodz.uni.math.naiApp.domain.Supplier;

import java.util.List;

/**
 * Created by HP on 2018-04-19.
 */
@Mapper
public interface ProductMapper {
    @Select("SELECT COUNT(*) FROM product")
    int getCount();

    @Select("Select id,code,product_code,name,body FROM product")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "supplier", column = "id", one = @One(select = "getSupplier"))
    })
    List<Product> getAllProducts();

    @Select("Select id, company_name,contact_number, city from supplier where id=#{id}")
    Supplier getSupplier(Integer id);

    @Insert("INSERT INTO PRODUCT(code,product_code,name,body,supplier) VALUES(#{code},#{product_code},#{name},#{body},#{supplier.id)")
    void insertProduct(Product product);

    @Update("UPDATE PRODUCT SET code=#{code},product_code=#{product_code},name=#{name},supplier=#{supplier.id} WHERE id=#{id}")
    void updateProduct(Product product);

    @Delete("DELETE FROM PRODUCT where id=#{id}")
    void deleteProduct(Integer id);
}
