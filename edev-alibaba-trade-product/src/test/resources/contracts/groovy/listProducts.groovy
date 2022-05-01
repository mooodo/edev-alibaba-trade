package contracts.groovy

import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description("load a list of products by ids.")
	request {
	    method POST()
	    url("/product/getAll")
		body([30001,30004])
		headers {
			contentType(applicationJson())
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