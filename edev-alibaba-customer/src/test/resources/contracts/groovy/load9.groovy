package contracts.groovy

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description("load a customer by id.")
	request {
	    method GET()
	    url("/orm/customer/load") {
	        queryParameters {
	            parameter("customerId","10009")
	        }
	    }
	}
	response {
	    body(file('load9.json'))
	    status 200
	    headers {
			contentType(applicationJson())
		}
	}
}