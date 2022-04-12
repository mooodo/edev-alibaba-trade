package com.edev.trade.customer.service.impl;

import com.edev.support.dao.BasicDao;
import com.edev.support.exception.ValidException;
import com.edev.support.utils.DateUtils;
import com.edev.trade.customer.entity.GoldenVip;
import com.edev.trade.customer.entity.SilverVip;
import com.edev.trade.customer.entity.Vip;
import com.edev.trade.customer.service.VipService;

import java.util.Collection;
import java.util.List;

public class VipServiceImpl implements VipService {
    private BasicDao dao;

    public BasicDao getDao() {
        return dao;
    }

    public void setDao(BasicDao dao) {
        this.dao = dao;
    }

    private void validVip(Vip vip) {
        if(vip.getId()==null) throw new ValidException("The id is null");
        if(vip.getVipType()==null) throw new ValidException("The vip type is null");
    }

    @Override
    public Long register(Vip vip) {
        validVip(vip);
        vip.setCreateTime(DateUtils.getNow());
        return dao.insert(vip);
    }

    @Override
    public void modify(Vip vip) {
        validVip(vip);
        vip.setUpdateTime(DateUtils.getNow());
        dao.update(vip);
    }

    @Override
    public void delete(Long vipId) {
        dao.delete(vipId, Vip.class);
    }

    @Override
    public void deleteVip(Vip vip) {
        dao.delete(vip);
    }

    @Override
    public Vip load(Long vipId) {
        return dao.load(vipId, Vip.class);
    }

    @Override
    public void saveAll(List<Vip> list) {
        list.forEach(vip->{
            validVip(vip);
            if(vip.getCreateTime()==null)
                vip.setCreateTime(DateUtils.getNow());
            else
                vip.setUpdateTime(DateUtils.getNow());
        });
        dao.insertOrUpdateForList(list);
    }

    @Override
    public void deleteAll(List<Long> vipIds) {
        dao.deleteForList(vipIds, Vip.class);
    }

    @Override
    public Collection<Vip> loadAll(List<Long> vipIds) {
        return dao.loadForList(vipIds, Vip.class);
    }

    @Override
    public Vip loadByCustomer(Long customerId) {
        return dao.load(customerId, Vip.class);
    }

    @Override
    public Double discount(Long customerId) {
        Vip vip = loadByCustomer(customerId);
        if(vip instanceof GoldenVip) return 0.9D;
        if(vip instanceof SilverVip) return 0.75D;
        return null;
    }
}
