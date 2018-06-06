package pl.lodz.uni.math.naiApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.lodz.uni.math.naiApp.domain.Shop;
import pl.lodz.uni.math.naiApp.service.OwnerService;
import pl.lodz.uni.math.naiApp.service.ShopService;

import java.util.List;

/**
 * Created by HP on 2018-06-06.
 */
@Controller
public class ShopController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/shop")
    public String getShopList(Model model) {
        model.addAttribute("shops", shopService.getShopList());
        return "shop";
    }

    @RequestMapping("/shop/delete")
    public String deleteShop(@RequestParam("id") int id) {
        shopService.deleteShop(id);
        return "redirect:/shop";
    }

    @PostMapping("/shop/add_shop")
    public String createShop(@ModelAttribute Shop shop) {
        shopService.createShop(shop);
        return "redirect:/shop";
    }

    @GetMapping("/shop/add_shop")
    public String createShopModel(Model model) {
        model.addAttribute("shop", new Shop());
        model.addAttribute("owners", ownerService.returnOwners());
        return "add_shop";
    }
    @RequestMapping("/shop/edit")
    public String editShopPage(Model model, @RequestParam("id") int id){
        model.addAttribute("shop",shopService.getShop(id));
        model.addAttribute("owners", ownerService.returnOwners());
        return "edit_shop";
    }
    @PostMapping("/shop/edit")
    public String updateShop(@ModelAttribute Shop shop){
        shopService.updateShop(shop);
        return "redirect:/shop";
    }
}
