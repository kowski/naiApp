package pl.lodz.uni.math.naiApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.lodz.uni.math.naiApp.domain.Supplier;
import pl.lodz.uni.math.naiApp.service.SupplierService;

import java.util.List;

/**
 * Created by HP on 2018-04-20.
 */
@Controller
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @GetMapping("/supplier/{id}")
    @ResponseBody
    public Supplier getSupplier(@PathVariable("id") String id) {
        return supplierService.getSupplierById(id);
    }

    @GetMapping("/supplier")
    @ResponseBody
    public List<Supplier> getSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @PostMapping("/supplier")
    @ResponseBody
    public void createSupplier(@RequestBody Supplier supplier) {

    }
}
