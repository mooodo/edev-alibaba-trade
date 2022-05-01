package contracts.groovy

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description("load an address by id.")
	request {
	    method GET()
	    url("/customer/loadAddress") {
	        queryParameters {
	            parameter("addressId","1000100")
	        }
	    }
	}
	response {
	    body(file('loadAddress.json'))
	    status 200
	    headers {
			contentType(applicationJson())
		}
	}
}