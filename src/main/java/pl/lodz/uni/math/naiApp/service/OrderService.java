package pl.lodz.uni.math.naiApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.uni.math.naiApp.domain.Order;
import pl.lodz.uni.math.naiApp.mapper.OrderMapper;

import java.util.List;

/**
 * Created by HP on 2018-06-05.
 */
@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    public List<Order> getAllOrders() {
        return orderMapper.getAllOrders();
    }
    public Integer getOrderCount(){
        return orderMapper.getOrderCount();
    }
}
