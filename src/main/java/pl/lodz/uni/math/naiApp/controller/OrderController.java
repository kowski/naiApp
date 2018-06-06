package pl.lodz.uni.math.naiApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.lodz.uni.math.naiApp.domain.Order;
import pl.lodz.uni.math.naiApp.service.OrderService;

import java.util.List;

/**
 * Created by HP on 2018-06-04.
 */
@Controller
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping("/order")
    public String returnOrders(Model model) {
        model.addAttribute("orders",orderService.getAllOrders());
        return "order";
    }

    @GetMapping("/orders")
    @ResponseBody
    public List<Order> returnOrdersA() {
        return orderService.getAllOrders();
    }
}
