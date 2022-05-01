package com.edev.trade.customer.web;

import com.edev.support.web.OrmController;
import com.edev.support.web.QueryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("vip")
public class VipController {
    @Autowired
    private OrmController ormController;
    @PostMapping("register")
    public Object register(@RequestBody Map<String, Object> json) {
        return ormController.doPost("vip", "register", json);
    }
    @PostMapping("modify")
    public void modify(@RequestBody Map<String, Object> json) {
        ormController.doPost("vip", "modify", json);
    }
    @GetMapping("delete")
    public void delete(HttpServletRequest request) {
        ormController.doGet("vip", "delete", request);
    }
    @GetMapping("load")
    public Object load(HttpServletRequest request) {
        return ormController.doGet("vip", "load", request);
    }
    @PostMapping("saveAll")
    public void saveAll(@RequestBody List<Object> list) {
        ormController.doList("vip","saveAll",list);
    }
    @PostMapping("deleteAll")
    public void deleteAll(@RequestBody List<Object> list) {
        ormController.doList("vip","deleteAll",list);
    }
    @PostMapping("loadAll")
    public Object loadAll(@RequestBody List<Object> list) {
        return ormController.doList("vip","loadAll",list);
    }
    @GetMapping("loadByCustomer")
    public Object loadByCustomer(HttpServletRequest request) {
        return ormController.doGet("vip","loadByCustomer",request);
    }
    @GetMapping("discount")
    public Object discount(HttpServletRequest request) {
        return ormController.doGet("vip","discount",request);
    }
    @Autowired
    private QueryController queryController;
    @PostMapping("query")
    public Object query(@RequestBody Map<String, Object> json) {
        return queryController.queryByPost("vipQry", json);
    }
    @GetMapping("query")
    public Object query(HttpServletRequest request) {
        return queryController.queryByGet("vipQry", request);
    }
}
