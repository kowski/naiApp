package pl.lodz.uni.math.naiApp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import pl.lodz.uni.math.naiApp.domain.ShopOwner;

import java.util.List;

/**
 * Created by HP on 2018-06-06.
 */
@Mapper
public interface OwnerMapper {
    @Select("Select id, name,surname, phone_numb,address from shop_owner")
    @Results(value = {
            @Result(property = "phoneNumb",column = "phone_numb")
    })
    List<ShopOwner> getOwners();
}
