package com.edev.trade.order.web;

import com.alibaba.fastjson.JSONObject;
import com.edev.support.utils.DateUtils;
import com.edev.trade.order.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureStubRunner(ids= {"com.edev.trade:edev-alibaba-trade-customer:+:stubs:9002",
        "com.edev.trade:edev-alibaba-trade-product:+:stubs:9003"},
        stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class OrderMvcTest {
    @Autowired
    private MockMvc mvc;
    @Test
    public void testSaveAndDelete() throws Exception {
        Long id = 1L;
        Order order = new Order(id,10001L,1000100L,5000D,
                DateUtils.getDate("2020-02-28","yyyy-MM-dd"),"create");
        Customer customer = new Customer(10001L,"李秋水","女",
                "510110197910012312","13388990123");
        order.setCustomer(customer);
        Address address = new Address(1000100L,10001L,1000L,420000L,
                420100L,420111L,"珞瑜路726号","13300224466");
        order.setAddress(address);
        String json = JSONObject.toJSONStringWithDateFormat(order,"yyyy-MM-dd HH:ss:mm");

        mvc.perform(get("/orm/order/delete")
                .param("orderId",id.toString())
        ).andExpect(status().isOk());
        mvc.perform(post("/orm/order/create")
                .content(json).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id.toString()));
        mvc.perform(get("/orm/order/load")
                .param("orderId", id.toString())
        ).andExpect(status().isOk()).andExpect(content().json(json));

        mvc.perform(get("/orm/order/delete")
                .param("orderId",id.toString())
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/order/load")
                .param("orderId", id.toString())
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
    @Test
    public void testSaveAndDeleteWithItem() throws Exception {
        Long id = 1L;
        Order order = new Order(id,10001L,1000100L,5916D,
                DateUtils.getDate("2020-04-20","yyyy-MM-dd"),"create");
        Customer customer = new Customer(10001L,"李秋水","女",
                "510110197910012312","13388990123");
        order.setCustomer(customer);
        Address address = new Address(1000100L,10001L,1000L,420000L,
                420100L,420111L,"珞瑜路726号","13300224466");
        order.setAddress(address);
        OrderItem orderItem0 = new OrderItem(1L,id,30001L,1L,4000D,4000D);
        Product product0 = new Product(30001L,"Apple iPhone X 256GB 深空灰色 移动联通电信4G手机",4000D,
                "台",20004L,100100L);
        orderItem0.setProduct(product0);
        order.addOrderItem(orderItem0);
        OrderItem orderItem1 = new OrderItem(2L,id,30004L,2L,958D,1916D);
        Product product1 = new Product(30004L,"Kindle Paperwhite电纸书阅读器 电子书墨水屏 6英寸wifi 黑色",958D,
                "个",20002L,100500L);
        orderItem1.setProduct(product1);
        order.addOrderItem(orderItem1);
        String json = JSONObject.toJSONStringWithDateFormat(order,"yyyy-MM-dd HH:ss:mm");

        mvc.perform(get("/orm/order/delete")
                .param("orderId",id.toString())
        ).andExpect(status().isOk());
        mvc.perform(post("/orm/order/create")
                .content(json).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(id.toString()));
        mvc.perform(get("/orm/order/load")
                .param("orderId", id.toString())
        ).andExpect(status().isOk()).andExpect(content().json(json));

        mvc.perform(get("/orm/order/delete")
                .param("orderId",id.toString())
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/order/load")
                .param("orderId", id.toString())
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }

    @Test
    public void testSaveAndDeleteForList() throws Exception {
        Long id0 = 1L;
        Order order0 = new Order(id0,10001L,1000100L,5000D,
                DateUtils.getDate("2020-02-28","yyyy-MM-dd"),"create");
        Customer customer0 = new Customer(10001L,"李秋水","女",
                "510110197910012312","13388990123");
        order0.setCustomer(customer0);
        Address address0 = new Address(1000100L,10001L,1000L,420000L,
                420100L,420111L,"珞瑜路726号","13300224466");
        order0.setAddress(address0);

        Long id1 = 2L;
        Order order1 = new Order(id1,10001L,1000100L,5916D,
                DateUtils.getDate("2020-04-20","yyyy-MM-dd"),"create");
        Customer customer1 = new Customer(10001L,"李秋水","女",
                "510110197910012312","13388990123");
        order0.setCustomer(customer1);
        Address address1 = new Address(1000100L,10001L,1000L,420000L,
                420100L,420111L,"珞瑜路726号","13300224466");
        order0.setAddress(address1);
        OrderItem orderItem0 = new OrderItem(1L,id1,30001L,1L,4000D,4000D);
        Product product0 = new Product(30001L,"Apple iPhone X 256GB 深空灰色 移动联通电信4G手机",4000D,
                "台",20004L,100100L);
        orderItem0.setProduct(product0);
        order1.addOrderItem(orderItem0);
        OrderItem orderItem1 = new OrderItem(2L,id1,30004L,2L,958D,1916D);
        Product product1 = new Product(30004L,"Kindle Paperwhite电纸书阅读器 电子书墨水屏 6英寸wifi 黑色",958D,
                "个",20002L,100500L);
        orderItem1.setProduct(product1);
        order1.addOrderItem(orderItem1);

        List<Order> orders = new ArrayList<>();
        orders.add(order0);
        orders.add(order1);
        String jsonArray = JSONObject.toJSONStringWithDateFormat(orders,"yyyy-MM-dd HH:ss:mm");

        mvc.perform(post("/list/order/deleteAll")
                .content("[1,2]").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(post("/list/order/saveAll")
                .content(jsonArray).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(post("/list/order/loadAll")
                .content("[1,2]").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().json(jsonArray));

        mvc.perform(post("/query/orderQry")
                .content("{\"page\":0,\"size\":10,\"aggregation\":{\"id\":\"count\",\"amount\":\"sum\"}}")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        mvc.perform(post("/list/order/deleteAll")
                .content("[1,2]").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(post("/list/order/loadAll")
                .content("[1,2]").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }

    @Test
    public void testSaveAndDeleteForJsonList() throws Exception {
        Long id0 = 1L;
        Order order0 = new Order(id0,10001L,1000100L,5000D,
                DateUtils.getDate("2020-02-28","yyyy-MM-dd"),"create");
        Customer customer0 = new Customer(10001L,"李秋水","女",
                "510110197910012312","13388990123");
        order0.setCustomer(customer0);
        Address address0 = new Address(1000100L,10001L,1000L,420000L,
                420100L,420111L,"珞瑜路726号","13300224466");
        order0.setAddress(address0);

        Long id1 = 2L;
        Order order1 = new Order(id1,10001L,1000100L,5916D,
                DateUtils.getDate("2020-04-20","yyyy-MM-dd"),"create");
        Customer customer1 = new Customer(10001L,"李秋水","女",
                "510110197910012312","13388990123");
        order0.setCustomer(customer1);
        Address address1 = new Address(1000100L,10001L,1000L,420000L,
                420100L,420111L,"珞瑜路726号","13300224466");
        order0.setAddress(address1);
        OrderItem orderItem0 = new OrderItem(1L,id1,30001L,1L,4000D,4000D);
        Product product0 = new Product(30001L,"Apple iPhone X 256GB 深空灰色 移动联通电信4G手机",4000D,
                "台",20004L,100100L);
        orderItem0.setProduct(product0);
        order1.addOrderItem(orderItem0);
        OrderItem orderItem1 = new OrderItem(2L,id1,30004L,2L,958D,1916D);
        Product product1 = new Product(30004L,"Kindle Paperwhite电纸书阅读器 电子书墨水屏 6英寸wifi 黑色",958D,
                "个",20002L,100500L);
        orderItem1.setProduct(product1);
        order1.addOrderItem(orderItem1);

        List<Order> orders = new ArrayList<>();
        orders.add(order0);
        orders.add(order1);
        String jsonArray = JSONObject.toJSONStringWithDateFormat(orders,"yyyy-MM-dd HH:ss:mm");

        Map<String, Object> map = new HashMap<>();
        map.put("orders", orders);
        String json = JSONObject.toJSONStringWithDateFormat(map,"yyyy-MM-dd HH:ss:mm");

        mvc.perform(get("/orm/order/deleteAll")
                .param("orderIds", "1,2")
        ).andExpect(status().isOk());
        mvc.perform(post("/orm/order/saveAll")
                .content(json).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/order/loadAll")
                .param("orderIds", "1,2")
        ).andExpect(status().isOk()).andExpect(content().json(jsonArray));

        mvc.perform(get("/query/orderQry")
                .param("page","0").param("size","10")
        ).andExpect(status().isOk());

        mvc.perform(get("/orm/order/deleteAll")
                .param("orderIds", "1,2")
        ).andExpect(status().isOk());
        mvc.perform(get("/orm/order/loadAll")
                .param("orderIds", "1,2")
        ).andExpect(status().isOk()).andExpect(content().string(""));
    }
}
