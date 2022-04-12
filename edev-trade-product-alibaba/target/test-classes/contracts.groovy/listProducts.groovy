package contracts.groovy

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description("load a list of products by ids.")
	request {
	    method GET()
	    url("/orm/product/listProducts") {
	        queryParameters {
	            parameter("ids", "30001,30002")
	        }
	    }
	}
	response {
		body(file('listProducts.json'))
	    status 200
	    headers {
			contentType(applicationJson())
		}
	}
}