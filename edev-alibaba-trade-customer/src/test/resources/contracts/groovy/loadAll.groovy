package contracts.groovy

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description("load a list of products by ids.")
	request {
	    method POST()
	    url("/customer/loadAll")
		body([10001])
		headers {
			contentType(applicationJson())
		}
	}
	response {
		body(file('loadAll.json'))
	    status 200
	    headers {
			contentType(applicationJson())
		}
	}
}