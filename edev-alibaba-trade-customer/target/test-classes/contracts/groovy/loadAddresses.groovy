package contracts.groovy

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description("load a list of products by ids.")
	request {
	    method POST()
	    url("/list/customer/loadAddresses")
		body([1000100])
		headers {
			contentType(applicationJson())
		}
	}
	response {
		body(file('loadAddresses.json'))
	    status 200
	    headers {
			contentType(applicationJson())
		}
	}
}