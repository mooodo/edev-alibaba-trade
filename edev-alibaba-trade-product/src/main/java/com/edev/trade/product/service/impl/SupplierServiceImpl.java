package com.edev.trade.product.service.impl;

import com.edev.support.dao.BasicDao;
import com.edev.support.exception.ValidException;
import com.edev.trade.product.entity.Supplier;
import com.edev.trade.product.service.SupplierService;

import java.util.Collection;
import java.util.List;

public class SupplierServiceImpl implements SupplierService {
    private final BasicDao dao;

    public SupplierServiceImpl(BasicDao dao) {
        this.dao = dao;
    }

    private void validSupplier(Supplier supplier) {
        if(supplier.getId()==null) throw new ValidException("The id is null");
        if(supplier.getName()==null) throw new ValidException("The name is null");
    }

    @Override
    public Long addSupplier(Supplier supplier) {
        validSupplier(supplier);
        return dao.insert(supplier);
    }

    @Override
    public void modifySupplier(Supplier supplier) {
        validSupplier(supplier);
        dao.update(supplier);
    }

    @Override
    public void removeSupplier(Long id) {
        dao.delete(id, Supplier.class);
    }

    @Override
    public Supplier getSupplier(Long id) {
        return dao.load(id, Supplier.class);
    }

    @Override
    public Collection<Supplier> listSuppliers(List<Long> ids) {
        return dao.loadForList(ids, Supplier.class);
    }
}
