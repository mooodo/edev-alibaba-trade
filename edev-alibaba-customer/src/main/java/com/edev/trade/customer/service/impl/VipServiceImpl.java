package com.edev.trade.customer.service.impl;

import com.edev.support.dao.BasicDao;
import com.edev.support.utils.DateUtils;
import com.edev.trade.customer.entity.Vip;
import com.edev.trade.customer.service.VipService;
import lombok.NonNull;
import org.springframework.dao.DataAccessException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collection;
import java.util.List;

import static com.edev.support.utils.ValidUtils.*;

public class VipServiceImpl implements VipService {
    private final BasicDao dao;
    public VipServiceImpl(BasicDao dao) {
        this.dao = dao;
    }

    private void validVip(@NonNull Vip vip) {
        isNull(vip.getId(), "The vip id is null");
        isNull(vip.getVipType(), "The vip type is null");
    }

    @Override
    public Long register(@NonNull Vip vip) {
        validVip(vip);
        vip.setCreateTime(DateUtils.getNow());
        return dao.insert(vip);
    }

    @Override
    public void modify(@NonNull Vip vip) {
        vip.setUpdateTime(DateUtils.getNow());
        dao.update(vip);
    }

    @Override
    public void delete(@NonNull Long vipId) {
        dao.delete(vipId, Vip.class);
    }

    @Override
    public void deleteVip(@NonNull Vip vip) {
        dao.delete(vip);
    }

    @Override
    public Vip load(@NonNull Long vipId) {
        return dao.load(vipId, Vip.class);
    }

    @Override
    public void saveAll(@NonNull List<Vip> list) {
        list.forEach(vip->{
            validVip(vip);
            try {
                register(vip);
            } catch (DataAccessException e) {
                if(e.getCause() instanceof SQLIntegrityConstraintViolationException)
                    modify(vip);
                else throw e;
            }
        });
    }

    @Override
    public void deleteAll(@NonNull List<Long> vipIds) {
        dao.deleteForList(vipIds, Vip.class);
    }

    @Override
    public Collection<Vip> loadAll(@NonNull List<Long> vipIds) {
        return dao.loadForList(vipIds, Vip.class);
    }

    @Override
    public Vip loadByCustomer(@NonNull Long customerId) {
        return dao.load(customerId, Vip.class);
    }

    @Override
    public Double discount(@NonNull Vip vip) {
        return vip.discount();
    }

    @Override
    public Double discount(@NonNull Long customerId) {
        Vip vip = loadByCustomer(customerId);
        if (vip==null|| !vip.getAvailable()) return 1D;
        return discount(vip);
    }
}
