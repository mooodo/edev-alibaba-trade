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
    private static final String BEAN = "product";
    @Autowired
    private OrmController ormController;
    @PostMapping("save")
    public Object save(@RequestBody Map<String, Object> json) {
        return ormController.doPost(BEAN, "saveProduct", json);
    }
    @PostMapping("saveAll")
    public Object saveAll(@RequestBody List<Object> list) {
        return ormController.doList(BEAN, "saveProducts", list);
    }
    @GetMapping("delete")
    public void delete(HttpServletRequest request) {
        ormController.doGet(BEAN, "deleteProduct", request);
    }
    @PostMapping("deleteAll")
    public void deleteAll(@RequestBody List<Object> list) {
        ormController.doList(BEAN, "deleteProducts", list);
    }
    @GetMapping("get")
    public Object get(HttpServletRequest request) {
        return ormController.doGet(BEAN, "getProduct", request);
    }
    @PostMapping("getAll")
    public Object getAll(@RequestBody List<Object> list) {
        return ormController.doList(BEAN, "listProducts", list);
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
