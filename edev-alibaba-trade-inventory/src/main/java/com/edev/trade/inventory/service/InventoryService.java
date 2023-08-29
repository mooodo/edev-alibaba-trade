package com.edev.trade.inventory.service;

import com.edev.trade.inventory.entity.Inventory;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface InventoryService {
    Long stockIn(Long id, Long quantity);
    void stockInForList(List<Map<String, Object>> list);
    Long stockOut(Long id, Long quantity);
    void stockOutForList(List<Map<String, Object>> list);
    void remove(Long id);
    Inventory checkInventory(Long id);
    Collection<Inventory> checkInventories(List<Long> ids);
}
