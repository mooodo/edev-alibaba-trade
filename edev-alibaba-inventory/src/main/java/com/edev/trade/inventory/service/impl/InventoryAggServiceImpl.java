package com.edev.trade.inventory.service.impl;

import com.edev.trade.inventory.service.InventoryAggService;
import com.edev.trade.inventory.service.InventoryService;
import io.seata.core.context.RootContext;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Slf4j
@Service("inventoryAgg")
public class InventoryAggServiceImpl implements InventoryAggService {
    @Autowired
    private InventoryService inventoryService;

    @Override
    @Transactional
    public void stockInForList(@NonNull List<Map<String, Object>> list) {
        log.info("begin the trade... xid: "+ RootContext.getXID());
        list.forEach(map -> {
            Long id = Long.valueOf(map.get("id").toString());
            Long quantity = Long.valueOf(map.get("quantity").toString());
            inventoryService.stockIn(id, quantity);
        });
    }

    @Override
    @Transactional
    public void stockOutForList(@NonNull List<Map<String, Object>> list) {
        log.info("begin the trade... xid: "+ RootContext.getXID());
        list.forEach(map -> {
            Long id = Long.valueOf(map.get("id").toString());
            Long quantity = Long.valueOf(map.get("quantity").toString());
            inventoryService.stockOut(id, quantity);
        });
    }
}
