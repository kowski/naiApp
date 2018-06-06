package pl.lodz.uni.math.naiApp.mapper;

import org.apache.ibatis.annotations.*;
import pl.lodz.uni.math.naiApp.domain.Shop;
import pl.lodz.uni.math.naiApp.domain.ShopOwner;

import java.util.List;

/**
 * Created by HP on 2018-06-06.
 */
@Mapper
public interface ShopMapper {
    @Select("SELECT id,name, city, owner_id FROM SHOP")
    @Results(value = {
            @Result(property = "shopOwner", column = "owner_id", one = @One(select = "getOwner"))
    })
    List<Shop> getAllShops();

    @Select("SELECT id,name, city, owner_id FROM SHOP where id=#{id}")
    @Results(value = {
            @Result(property = "shopOwner", column = "owner_id", one = @One(select = "getOwner"))
    })
    Shop getShop(Integer id);

    @Select("Select id, name,surname, phone_numb,address from shop_owner where id=#{id}")
    @Results(value = {
            @Result(property = "phoneNumb", column = "phone_numb")
    })
    ShopOwner getOwner(Integer id);

    @Insert("INSERT INTO SHOP(name,city, owner_id) VALUES(#{name},#{city},#{shopOwner.id})")
    void createShop(Shop shop);

    @Delete("DELETE FROM SHOP where id=#{id}")
    void deleteShop(Integer id);

    @Update("UPDATE SHOP SET name=#{name},city=#{city},owner_id=#{shopOwner.id} WHERE id=#{id}")
    void updateShop(Shop shop);

}
