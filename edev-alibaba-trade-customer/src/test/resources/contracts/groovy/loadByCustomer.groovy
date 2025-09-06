package contracts.groovy

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("load a customer's vip by his customer id.")
    request {
        method GET()
        url("/orm/vip/loadByCustomer") {
            queryParameters {
                parameter("customerId","10001")
            }
        }
    }
    response {
        body("null")
        status 200
        headers {
            contentType(textPlain())
        }
    }
}