package com.edev.trade.order.web;

import com.edev.support.web.OrmController;
import com.edev.support.web.QueryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrmController ormController;
    @PostMapping("create")
    public Object create(@RequestBody Map<String, Object> json) {
        return ormController.doPost("order", "create", json);
    }
    @PostMapping("modify")
    public void modify(@RequestBody Map<String, Object> json) {
        ormController.doPost("order", "modify", json);
    }
    @GetMapping("delete")
    public void delete(HttpServletRequest request) {
        ormController.doGet("order", "delete", request);
    }
    @GetMapping("load")
    public Object load(HttpServletRequest request) {
        return ormController.doGet("order", "load", request);
    }
    @Autowired
    private QueryController queryController;
    @PostMapping("query")
    public Object query(@RequestBody Map<String, Object> json) {
        return queryController.queryByPost("productQry", json);
    }
    @GetMapping("query")
    public Object query(HttpServletRequest request) {
        return queryController.queryByGet("productQry", request);
    }
}
