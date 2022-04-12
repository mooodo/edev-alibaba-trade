package com.edev.trade.customer.web;

import com.edev.support.web.OrmController;
import com.edev.support.web.QueryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
