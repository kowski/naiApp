package pl.lodz.uni.math.naiApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.uni.math.naiApp.domain.ShopOwner;
import pl.lodz.uni.math.naiApp.mapper.OwnerMapper;
import java.util.List;

/**
 * Created by HP on 2018-06-06.
 */
@Service
public class OwnerService {
    @Autowired
    OwnerMapper ownerMapper;

    public List<ShopOwner> returnOwners() {
        return ownerMapper.getOwners();
    }
}
