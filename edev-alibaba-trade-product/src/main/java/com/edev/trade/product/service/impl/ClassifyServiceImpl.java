package com.edev.trade.product.service.impl;

import com.edev.support.dao.BasicDao;
import com.edev.trade.product.entity.Classify;
import com.edev.trade.product.service.ClassifyService;

import java.util.Collection;

public class ClassifyServiceImpl implements ClassifyService {
    private final BasicDao dao;
    public ClassifyServiceImpl(BasicDao dao) {
        this.dao = dao;
    }
    @Override
    public Collection<Classify> getAll() {
        return dao.loadAll(new Classify());
    }
}
