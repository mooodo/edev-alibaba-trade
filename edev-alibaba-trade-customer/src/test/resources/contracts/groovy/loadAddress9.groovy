package contracts.groovy

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description("load an address by id.")
	request {
	    method GET()
	    url("/orm/customer/loadAddress") {
	        queryParameters {
	            parameter("addressId","1000900")
	        }
	    }
	}
	response {
	    body(file('loadAddress9.json'))
	    status 200
	    headers {
			contentType(applicationJson())
		}
	}
}