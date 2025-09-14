package contracts.groovy

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description("load a product by id.")
	request {
	    method GET()
	    url("/orm/product/getProduct") {
	        queryParameters {
	            parameter("id","30007")
	        }
	    }
	}
	response {
	    body(file('getProduct7.json'))
	    status 200
	    headers {
			contentType(applicationJson())
		}
	}
}