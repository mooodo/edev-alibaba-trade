package contracts.groovy

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("load a customer's vip by his customer id.")
    request {
        method GET()
        url("/orm/vip/loadByCustomer") {
            queryParameters {
                parameter("customerId","10009")
            }
        }
    }
    response {
        body(file('loadByCustomer.json'))
        status 200
        headers {
            contentType(applicationJson())
        }
    }
}