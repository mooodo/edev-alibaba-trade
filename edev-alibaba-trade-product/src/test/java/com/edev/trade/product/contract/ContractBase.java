/*
 * Created by 2020-05-03 20:35:13 
 */
package com.edev.trade.product.contract;

import com.edev.support.web.OrmController;
import com.edev.trade.product.web.ProductController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author fangang
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractBase {
	@Autowired
	private OrmController controller;
	@Autowired
	private ProductController productController;
	@Before
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(controller,productController);
	}
}
