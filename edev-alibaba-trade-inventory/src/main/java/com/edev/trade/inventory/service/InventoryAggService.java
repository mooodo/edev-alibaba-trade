package com.edev.trade.inventory.service;

import java.util.List;
import java.util.Map;

public interface InventoryAggService {
    void stockInForList(List<Map<String, Object>> list);
    void stockOutForList(List<Map<String, Object>> list);
}
