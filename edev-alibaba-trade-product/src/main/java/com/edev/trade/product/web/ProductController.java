package com.edev.trade.product.web;

import com.edev.support.web.OrmController;
import com.edev.support.web.QueryController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private OrmController ormController;
    @PostMapping("save")
    public Object save(@RequestBody Map<String, Object> json) {
        return ormController.doPost("product", "saveProduct", json);
    }
    @PostMapping("saveAll")
    public Object saveAll(@RequestBody List<Object> list) {
        return ormController.doList("product", "saveProducts", list);
    }
    @GetMapping("delete")
    public void delete(HttpServletRequest request) {
        ormController.doGet("product", "deleteProduct", request);
    }
    @GetMapping("deleteAll")
    public void deleteAll(HttpServletRequest request) {
        ormController.doGet("product", "deleteProducts", request);
    }
    @GetMapping("get")
    public Object get(HttpServletRequest request) {
        return ormController.doGet("product", "getProduct", request);
    }
    @GetMapping("getAll")
    public Object getAll(HttpServletRequest request) {
        return ormController.doGet("product", "listProducts", request);
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
