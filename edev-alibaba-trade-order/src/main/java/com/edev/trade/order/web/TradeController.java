package com.edev.trade.order.web;

import com.edev.support.web.OrmController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("trade")
public class TradeController {
    @Autowired
    private OrmController ormController;
    @PostMapping("doTrade")
    public Object doTrade(@RequestBody Map<String, Object> json) {
        return ormController.doPost("trade", "doTrade", json);
    }
}
