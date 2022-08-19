package com.edev.trade.customer.web;

import com.edev.support.web.OrmController;
import com.edev.support.web.QueryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private OrmController ormController;
    @PostMapping("register")
    public Object register(@RequestBody Map<String, Object> json) {
        return ormController.doPost("customer","register",json);
    }
    @PostMapping("modify")
    public void modify(@RequestBody Map<String, Object> json) {
        ormController.doPost("customer","modify",json);
    }
    @GetMapping("delete")
    public void delete(HttpServletRequest request) {
        ormController.doGet("customer","delete", request);
    }
    @GetMapping("load")
    public Object load(HttpServletRequest request) {
        return ormController.doGet("customer","load",request);
    }
    @PostMapping("saveAll")
    public void saveAll(@RequestBody List<Object> list) {
        ormController.doList("customer","saveAll", list);
    }
    @PostMapping("deleteAll")
    public void deleteAll(@RequestBody List<Object> list) {
        ormController.doList("customer","deleteAll",list);
    }
    @PostMapping("loadAll")
    public Object loadAll(@RequestBody List<Object> list) {
        return ormController.doList("customer", "loadAll",list);
    }
    @GetMapping("loadAddress")
    public Object loadAddress(HttpServletRequest request) {
        return ormController.doGet("customer","loadAddress",request);
    }
    @PostMapping("loadAddresses")
    public Object loadAddresses(@RequestBody List<Object> list) {
        return ormController.doList("customer","loadAddresses",list);
    }
    @Autowired
    private QueryController queryController;
    @PostMapping("query")
    public Object query(@RequestBody Map<String, Object> json) {
        return queryController.queryByPost("customerQry", json);
    }
    @GetMapping("query")
    public Object query(HttpServletRequest request) {
        return queryController.queryByGet("customerQry", request);
    }
}
