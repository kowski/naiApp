package pl.lodz.uni.math.naiApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.uni.math.naiApp.domain.Shop;
import pl.lodz.uni.math.naiApp.mapper.ShopMapper;

import java.util.List;

/**
 * Created by HP on 2018-06-06.
 */
@Service
public class ShopService {
    @Autowired
    ShopMapper shopMapper;

    public List<Shop> getShopList() {
        return shopMapper.getAllShops();
    }

    public void createShop(Shop shop) {
        shopMapper.createShop(shop);
    }

    public void deleteShop(int id) {
        shopMapper.deleteShop(id);
    }

    public Shop getShop(int id) {
        return shopMapper.getShop(id);
    }
    public void updateShop(Shop shop){
        shopMapper.updateShop(shop);
    }
}
