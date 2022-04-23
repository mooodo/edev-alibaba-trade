package com.edev.trade.product.contract;

import com.edev.trade.product.contract.ContractBase;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.response.ResponseOptions;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat;
import static org.springframework.cloud.contract.verifier.util.ContractVerifierUtil.*;

public class GroovyTest extends ContractBase {

	@Test
	public void validate_getProduct() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();

		// when:
			ResponseOptions response = given().spec(request)
					.queryParam("id","30001")
					.get("/orm/product/getProduct");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).matches("application/json.*");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).field("['image']").isEqualTo("/static/img/product1.jpg");
			assertThatJson(parsedJson).field("['classify']").field("['parentId']").isEqualTo(100000);
			assertThatJson(parsedJson).field("['id']").isEqualTo(30001);
			assertThatJson(parsedJson).field("['classifyId']").isEqualTo(100100);
			assertThatJson(parsedJson).field("['classify']").field("['name']").isEqualTo("\u667A\u80FD\u624B\u673A");
			assertThatJson(parsedJson).field("['classify']").field("['id']").isEqualTo(100100);
			assertThatJson(parsedJson).field("['tip']").isEqualTo("\u81EA\u8425");
			assertThatJson(parsedJson).field("['price']").isEqualTo(4000);
			assertThatJson(parsedJson).field("['unit']").isEqualTo("\u53F0");
			assertThatJson(parsedJson).field("['originalPrice']").isEqualTo(5600);
			assertThatJson(parsedJson).field("['name']").isEqualTo("Apple iPhone X 256GB \u6DF1\u7A7A\u7070\u8272 \u79FB\u52A8\u8054\u901A\u7535\u4FE14G\u624B\u673A");
			assertThatJson(parsedJson).field("['supplierId']").isEqualTo(20004);
	}

	@Test
	public void validate_listProducts() throws Exception {
		// given:
			MockMvcRequestSpecification request = given()
					.header("Content-Type", "application/json")
					.body("[30001,30004]");

		// when:
			ResponseOptions response = given().spec(request)
					.post("/list/product/listProducts");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).matches("application/json.*");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).array().field("['classify']").field("['id']").isEqualTo(100500);
			assertThatJson(parsedJson).array().contains("['classifyId']").isEqualTo(100100);
			assertThatJson(parsedJson).array().contains("['tip']").isEqualTo("\u81EA\u8425");
			assertThatJson(parsedJson).array().field("['classify']").field("['name']").isEqualTo("\u667A\u80FD\u624B\u673A");
			assertThatJson(parsedJson).array().contains("['originalPrice']").isEqualTo(5600);
			assertThatJson(parsedJson).array().field("['classify']").field("['name']").isEqualTo("\u7535\u7EB8\u4E66");
			assertThatJson(parsedJson).array().contains("['name']").isEqualTo("Kindle Paperwhite\u7535\u7EB8\u4E66\u9605\u8BFB\u5668 \u7535\u5B50\u4E66\u58A8\u6C34\u5C4F 6\u82F1\u5BF8wifi \u9ED1\u8272");
			assertThatJson(parsedJson).array().contains("['classifyId']").isEqualTo(100500);
			assertThatJson(parsedJson).array().contains("['name']").isEqualTo("Apple iPhone X 256GB \u6DF1\u7A7A\u7070\u8272 \u79FB\u52A8\u8054\u901A\u7535\u4FE14G\u624B\u673A");
			assertThatJson(parsedJson).array().field("['classify']").field("['parentId']").isEqualTo(100000);
			assertThatJson(parsedJson).array().contains("['supplierId']").isEqualTo(20002);
			assertThatJson(parsedJson).array().contains("['supplierId']").isEqualTo(20004);
			assertThatJson(parsedJson).array().contains("['unit']").isEqualTo("\u4E2A");
			assertThatJson(parsedJson).array().contains("['image']").isEqualTo("/static/img/product1.jpg");
			assertThatJson(parsedJson).array().contains("['originalPrice']").isEqualTo(999);
			assertThatJson(parsedJson).array().contains("['id']").isEqualTo(30004);
			assertThatJson(parsedJson).array().contains("['id']").isEqualTo(30001);
			assertThatJson(parsedJson).array().contains("['image']").isEqualTo("/static/img/product4.jpg");
			assertThatJson(parsedJson).array().field("['classify']").field("['id']").isEqualTo(100100);
			assertThatJson(parsedJson).array().contains("['price']").isEqualTo(958);
			assertThatJson(parsedJson).array().contains("['unit']").isEqualTo("\u53F0");
			assertThatJson(parsedJson).array().contains("['price']").isEqualTo(4000);
	}

}
