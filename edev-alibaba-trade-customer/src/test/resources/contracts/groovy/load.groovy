package contracts.groovy

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description("load a customer by id.")
	request {
	    method GET()
	    url("/customer/load") {
	        queryParameters {
	            parameter("customerId","10001")
	        }
	    }
	}
	response {
	    body(file('load.json'))
	    status 200
	    headers {
			contentType(applicationJson())
		}
	}
}