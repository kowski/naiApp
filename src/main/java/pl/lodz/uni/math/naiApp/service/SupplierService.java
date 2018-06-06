package pl.lodz.uni.math.naiApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lodz.uni.math.naiApp.domain.Supplier;
import pl.lodz.uni.math.naiApp.mapper.SupplierMapper;

import java.util.List;

/**
 * Created by HP on 2018-04-20.
 */
@Service
public class SupplierService {
    @Autowired
    SupplierMapper supplierMapper;

    public Supplier getSupplierById(String id) {
        return supplierMapper.getSupplierById(Integer.valueOf(id));
    }

    public List<Supplier> getAllSuppliers() {
        return supplierMapper.getAllSuppliers();
    }

    public void createSupplier(Supplier supplier) {
        supplierMapper.createSupplier(supplier);
    }

    public void deleteSupplier(Integer id) {
        supplierMapper.deleteSupplier(id);
    }

    public void updateSupplier(Supplier supplier) {
        supplierMapper.updateSupplier(supplier);
    }
}
