package com.edev.trade.product.service;

import com.edev.trade.product.entity.Supplier;

import java.util.Collection;
import java.util.List;

public interface SupplierService {
    Long addSupplier(Supplier supplier);
    void modifySupplier(Supplier supplier);
    void removeSupplier(Long id);
    Supplier getSupplier(Long id);
    Collection<Supplier> listSuppliers(List<Long> ids);
}
