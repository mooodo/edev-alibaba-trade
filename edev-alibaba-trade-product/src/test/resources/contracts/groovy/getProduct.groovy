package contracts.groovy

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description("load a product by id.")
	request {
	    method GET()
	    url("/product/get") {
	        queryParameters {
	            parameter("id","30001")
	        }
	    }
	}
	response {
	    body(file('getProduct.json'))
	    status 200
	    headers {
			contentType(applicationJson())
		}
	}
}