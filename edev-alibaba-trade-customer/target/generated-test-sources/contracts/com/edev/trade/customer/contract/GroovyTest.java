package com.edev.trade.customer.contract;

import com.edev.trade.customer.contract.ContractBase;
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
	public void validate_load() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();

		// when:
			ResponseOptions response = given().spec(request)
					.queryParam("customerId","10001")
					.get("/orm/customer/load");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).matches("application/json.*");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).field("['identification']").isEqualTo("510110197910012312");
			assertThatJson(parsedJson).array("['addresses']").contains("['zoneId']").isEqualTo(420111);
			assertThatJson(parsedJson).array("['addresses']").contains("['cityId']").isEqualTo(421000);
			assertThatJson(parsedJson).array("['addresses']").contains("['zoneId']").isEqualTo(421002);
			assertThatJson(parsedJson).field("['gender']").isEqualTo("\u5973");
			assertThatJson(parsedJson).field("['phoneNumber']").isEqualTo("13388990123");
			assertThatJson(parsedJson).array("['addresses']").contains("['provinceId']").isEqualTo(420000);
			assertThatJson(parsedJson).array("['addresses']").contains("['id']").isEqualTo(1000100);
			assertThatJson(parsedJson).array("['addresses']").contains("['id']").isEqualTo(1000101);
			assertThatJson(parsedJson).array("['addresses']").contains("['phoneNumber']").isEqualTo("13388990123");
			assertThatJson(parsedJson).array("['addresses']").contains("['cityId']").isEqualTo(420100);
			assertThatJson(parsedJson).field("['id']").isEqualTo(10001);
			assertThatJson(parsedJson).field("['birthdate']").isEqualTo(307555200000L);
			assertThatJson(parsedJson).array("['addresses']").contains("['countryId']").isEqualTo(1000);
			assertThatJson(parsedJson).array("['addresses']").contains("['phoneNumber']").isEqualTo("13300224466");
			assertThatJson(parsedJson).field("['name']").isEqualTo("\u674E\u79CB\u6C34");
			assertThatJson(parsedJson).array("['addresses']").contains("['address']").isEqualTo("\u73DE\u745C\u8DEF726\u53F7");
			assertThatJson(parsedJson).array("['addresses']").contains("['customerId']").isEqualTo(10001);
			assertThatJson(parsedJson).array("['addresses']").contains("['address']").isEqualTo("\u5317\u4EAC\u897F\u8DEF410\u53F7");
	}

	@Test
	public void validate_loadAddress() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();

		// when:
			ResponseOptions response = given().spec(request)
					.queryParam("addressId","1000100")
					.get("/orm/customer/loadAddress");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).matches("application/json.*");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).field("['zone']").field("['name']").isEqualTo("\u6D2A\u5C71\u533A");
			assertThatJson(parsedJson).field("['country']").field("['name']").isEqualTo("\u4E2D\u56FD");
			assertThatJson(parsedJson).field("['zone']").field("['id']").isEqualTo(420111);
			assertThatJson(parsedJson).field("['province']").field("['id']").isEqualTo(420000);
			assertThatJson(parsedJson).field("['countryId']").isEqualTo(1000);
			assertThatJson(parsedJson).field("['provinceId']").isEqualTo(420000);
			assertThatJson(parsedJson).field("['id']").isEqualTo(1000100);
			assertThatJson(parsedJson).field("['country']").field("['id']").isEqualTo(1000);
			assertThatJson(parsedJson).field("['cityId']").isEqualTo(420100);
			assertThatJson(parsedJson).field("['customerId']").isEqualTo(10001);
			assertThatJson(parsedJson).field("['address']").isEqualTo("\u73DE\u745C\u8DEF726\u53F7");
			assertThatJson(parsedJson).field("['province']").field("['name']").isEqualTo("\u6E56\u5317\u7701");
			assertThatJson(parsedJson).field("['province']").field("['countryId']").isEqualTo(1000);
			assertThatJson(parsedJson).field("['city']").field("['provinceId']").isEqualTo(420000);
			assertThatJson(parsedJson).field("['zone']").field("['provinceId']").isEqualTo(420000);
			assertThatJson(parsedJson).field("['zone']").field("['cityId']").isEqualTo(420100);
			assertThatJson(parsedJson).field("['city']").field("['name']").isEqualTo("\u6B66\u6C49\u5E02");
			assertThatJson(parsedJson).field("['phoneNumber']").isEqualTo("13300224466");
			assertThatJson(parsedJson).field("['zoneId']").isEqualTo(420111);
			assertThatJson(parsedJson).field("['city']").field("['id']").isEqualTo(420100);
	}

	@Test
	public void validate_loadAddresses() throws Exception {
		// given:
			MockMvcRequestSpecification request = given()
					.header("Content-Type", "application/json")
					.body("[1000100]");

		// when:
			ResponseOptions response = given().spec(request)
					.post("/list/customer/loadAddresses");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).matches("application/json.*");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).array().contains("['zoneId']").isEqualTo(420111);
			assertThatJson(parsedJson).array().field("['zone']").field("['provinceId']").isEqualTo(420000);
			assertThatJson(parsedJson).array().field("['city']").field("['provinceId']").isEqualTo(420000);
			assertThatJson(parsedJson).array().field("['city']").field("['name']").isEqualTo("\u6B66\u6C49\u5E02");
			assertThatJson(parsedJson).array().field("['city']").field("['id']").isEqualTo(420100);
			assertThatJson(parsedJson).array().contains("['address']").isEqualTo("\u73DE\u745C\u8DEF726\u53F7");
			assertThatJson(parsedJson).array().field("['province']").field("['id']").isEqualTo(420000);
			assertThatJson(parsedJson).array().field("['zone']").field("['name']").isEqualTo("\u6D2A\u5C71\u533A");
			assertThatJson(parsedJson).array().field("['zone']").field("['cityId']").isEqualTo(420100);
			assertThatJson(parsedJson).array().contains("['id']").isEqualTo(1000100);
			assertThatJson(parsedJson).array().contains("['cityId']").isEqualTo(420100);
			assertThatJson(parsedJson).array().contains("['customerId']").isEqualTo(10001);
			assertThatJson(parsedJson).array().field("['zone']").field("['id']").isEqualTo(420111);
			assertThatJson(parsedJson).array().field("['province']").field("['countryId']").isEqualTo(1000);
			assertThatJson(parsedJson).array().contains("['phoneNumber']").isEqualTo("13300224466");
			assertThatJson(parsedJson).array().field("['country']").field("['id']").isEqualTo(1000);
			assertThatJson(parsedJson).array().field("['country']").field("['name']").isEqualTo("\u4E2D\u56FD");
			assertThatJson(parsedJson).array().contains("['countryId']").isEqualTo(1000);
			assertThatJson(parsedJson).array().contains("['provinceId']").isEqualTo(420000);
			assertThatJson(parsedJson).array().field("['province']").field("['name']").isEqualTo("\u6E56\u5317\u7701");
	}

	@Test
	public void validate_loadAll() throws Exception {
		// given:
			MockMvcRequestSpecification request = given()
					.header("Content-Type", "application/json")
					.body("[10001]");

		// when:
			ResponseOptions response = given().spec(request)
					.post("/list/customer/loadAll");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).matches("application/json.*");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).array().array("['addresses']").contains("['customerId']").isEqualTo(10001);
			assertThatJson(parsedJson).array().array("['addresses']").contains("['phoneNumber']").isEqualTo("13300224466");
			assertThatJson(parsedJson).array().array("['addresses']").contains("['address']").isEqualTo("\u5317\u4EAC\u897F\u8DEF410\u53F7");
			assertThatJson(parsedJson).array().contains("['birthdate']").isEqualTo(307555200000L);
			assertThatJson(parsedJson).array().array("['addresses']").contains("['id']").isEqualTo(1000100);
			assertThatJson(parsedJson).array().array("['addresses']").contains("['id']").isEqualTo(1000101);
			assertThatJson(parsedJson).array().array("['addresses']").contains("['countryId']").isEqualTo(1000);
			assertThatJson(parsedJson).array().contains("['name']").isEqualTo("\u674E\u79CB\u6C34");
			assertThatJson(parsedJson).array().contains("['identification']").isEqualTo("510110197910012312");
			assertThatJson(parsedJson).array().array("['addresses']").contains("['zoneId']").isEqualTo(420111);
			assertThatJson(parsedJson).array().array("['addresses']").contains("['provinceId']").isEqualTo(420000);
			assertThatJson(parsedJson).array().contains("['id']").isEqualTo(10001);
			assertThatJson(parsedJson).array().array("['addresses']").contains("['cityId']").isEqualTo(421000);
			assertThatJson(parsedJson).array().array("['addresses']").contains("['zoneId']").isEqualTo(421002);
			assertThatJson(parsedJson).array().contains("['gender']").isEqualTo("\u5973");
			assertThatJson(parsedJson).array().array("['addresses']").contains("['cityId']").isEqualTo(420100);
			assertThatJson(parsedJson).array().contains("['phoneNumber']").isEqualTo("13388990123");
			assertThatJson(parsedJson).array().array("['addresses']").contains("['address']").isEqualTo("\u73DE\u745C\u8DEF726\u53F7");
			assertThatJson(parsedJson).array().array("['addresses']").contains("['phoneNumber']").isEqualTo("13388990123");
	}

}
