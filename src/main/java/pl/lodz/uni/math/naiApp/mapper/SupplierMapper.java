package pl.lodz.uni.math.naiApp.mapper;

import org.apache.ibatis.annotations.*;
import pl.lodz.uni.math.naiApp.domain.Product;
import pl.lodz.uni.math.naiApp.domain.Supplier;

import java.util.List;

/**
 * Created by HP on 2018-04-20.
 */
@Mapper
public interface SupplierMapper {
    @Select("Select * FROM SUPPLIER")
    List<Supplier> getAllSuppliers();

    @Select("SELECT id, company_name,contact_number, city from SUPPLIER WHERE id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "company_name", column = "company_name"),
            @Result(property = "contact_number", column = "contact_number"),
            @Result(property = "city", column = "city"),
            @Result(property = "productsList", column = "id", javaType = List.class, many = @Many(select = "getProduct"))
    })
    public Supplier getSupplierById(Integer id);

    @Select("SELECT ID, CODE,PRODUCT_CODE, NAME, BODY FROM PRODUCT where supplier_id=#{supplier_id}")
    List<Product> getProduct(Integer supplier_id);

    @Insert("INSERT INTO supplier(company_name,contact_number,city) VALUES(#{company_name},#{contact_number},#{city})")
    void createSupplier(Supplier supplier);

    @Update("UPDATE SUPPLIER SET company_name=#{company_name},contact_number=#{contact_number},city=#{city} WHERE id=#{id}")
    void updateSupplier(Supplier supplier);

    @Delete("DELETE FROM SUPPLIER where id=#{id}")
    void deleteSupplier(int id);

}
