package contracts.groovy

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description("load a list of products by ids.")
	request {
	    method POST()
	    url("/list/product/listProducts")
		body([30005,30007])
		headers {
			contentType(applicationJson())
		}
	}
	response {
		body(file('listProducts57.json'))
	    status 200
	    headers {
			contentType(applicationJson())
		}
	}
}