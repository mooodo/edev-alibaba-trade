package com.edev.trade.inventory.service.impl;

import com.edev.support.dao.BasicDao;
import com.edev.support.exception.ValidException;
import com.edev.support.utils.DateUtils;
import com.edev.trade.inventory.entity.Inventory;
import com.edev.trade.inventory.exception.InventoryException;
import com.edev.trade.inventory.service.InventoryService;
import io.seata.core.context.RootContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class InventoryServiceImpl implements InventoryService {
    private final Log log = LogFactory.getLog(InventoryServiceImpl.class);
    private final BasicDao dao;

    public InventoryServiceImpl(BasicDao dao) {
        this.dao = dao;
    }

    private void valid(Inventory inventory) {
        if(inventory.getId()==null) throw new ValidException("The id is null");
        if(inventory.getQuantity()==null) inventory.setQuantity(0L);
        inventory.setUpdateTime(DateUtils.getNow());
    }

    private void create(Inventory inventory) {
        valid(inventory);
        dao.insert(inventory);
    }

    private void modify(Inventory inventory) {
        valid(inventory);
        dao.update(inventory);
    }

    @Override
    public void remove(Long id) {
        dao.delete(id, Inventory.class);
    }

    @Override
    public Long stockIn(Long id, Long quantity) {
        Inventory inventory = checkInventory(id);
        if(inventory==null) {
            inventory = Inventory.build().setValues(id, quantity, null);
            create(inventory);
            return quantity;
        }
        inventory.setQuantity(inventory.getQuantity() + quantity);
        modify(inventory);
        return inventory.getQuantity();
    }

    @Override
    @Transactional
    public void stockInForList(List<Map<String, Object>> list) {
        log.info("begin the trade... xid: "+ RootContext.getXID());
        list.forEach(map -> {
            Long id = Long.valueOf(map.get("id").toString());
            Long quantity = Long.valueOf(map.get("quantity").toString());
            stockIn(id, quantity);
        });
    }

    @Override
    public Long stockOut(Long id, Long quantity) {
        Inventory inventory = checkInventory(id);
        if(inventory==null||inventory.getQuantity()==null)
            throw new InventoryException("The product[productId: %s] have no inventory", id);
        Long deducted = inventory.getQuantity() - quantity;
        if(deducted < 0 )
            throw new InventoryException("The product have not enough stock: [productId: %s, current stock: %s]",
            id, inventory.getQuantity());
        inventory.setQuantity(deducted);
        modify(inventory);
        return deducted;
    }

    @Override
    @Transactional
    public void stockOutForList(@NotNull List<Map<String, Object>> list) {
        log.info("begin the trade... xid: "+ RootContext.getXID());
        list.forEach(map -> {
            Long id = Long.valueOf(map.get("id").toString());
            Long quantity = Long.valueOf(map.get("quantity").toString());
            stockOut(id, quantity);
        });
    }

    @Override
    public Inventory checkInventory(Long id) {
        return dao.load(id, Inventory.class);
    }

    @Override
    public Collection<Inventory> checkInventories(List<Long> ids) {
        return dao.loadForList(ids, Inventory.class);
    }
}
