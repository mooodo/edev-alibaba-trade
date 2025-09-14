package com.edev.trade.inventory.service.impl;

import com.edev.support.dao.BasicDao;
import com.edev.support.utils.DateUtils;
import com.edev.trade.inventory.entity.Inventory;
import com.edev.trade.inventory.service.InventoryService;
import lombok.NonNull;

import java.util.Collection;
import java.util.List;

import static com.edev.support.utils.ValidUtils.*;

public class InventoryServiceImpl implements InventoryService {
    private final BasicDao dao;

    public InventoryServiceImpl(BasicDao dao) {
        this.dao = dao;
    }

    private void valid(@NonNull Inventory inventory) {
        isNull(inventory.getId(), "The inventory id is null");
        if(inventory.getQuantity()==null) inventory.setQuantity(0L);
        inventory.setUpdateTime(DateUtils.getNow());
    }

    private void create(@NonNull Inventory inventory) {
        valid(inventory);
        dao.insert(inventory);
    }

    private void modify(@NonNull Inventory inventory) {
        valid(inventory);
        dao.update(inventory);
    }

    @Override
    public void remove(@NonNull Long id) {
        dao.delete(id, Inventory.class);
    }

    @Override
    public Long stockIn(@NonNull Long id, @NonNull Long quantity) {
        Inventory inventory = checkInventory(id);
        if(inventory==null) {
            inventory = new Inventory(id, quantity, null);
            create(inventory);
            return quantity;
        }
        inventory.setQuantity(inventory.getQuantity() + quantity);
        modify(inventory);
        return inventory.getQuantity();
    }

    @Override
    public Long stockOut(@NonNull Long id, @NonNull Long quantity) {
        Inventory inventory = checkInventory(id);
        isError((inventory==null||inventory.getQuantity()==null),
                "The product[productId: %s] have no inventory", id);
        Long deducted = inventory.getQuantity() - quantity;
        isError(deducted < 0,
                "The product have not enough stock: [productId: %s, current stock: %s]",
                id, inventory.getQuantity());
        inventory.setQuantity(deducted);
        modify(inventory);
        return deducted;
    }

    @Override
    public Inventory checkInventory(@NonNull Long id) {
        return dao.load(id, Inventory.class);
    }

    @Override
    public Collection<Inventory> checkInventories(@NonNull List<Long> ids) {
        return dao.loadForList(ids, Inventory.class);
    }
}
