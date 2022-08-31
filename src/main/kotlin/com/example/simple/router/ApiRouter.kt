package com.example.simple.router

import com.example.simple.handler.ApiHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates.path
import org.springframework.web.reactive.function.server.RouterFunctions.nest
import org.springframework.web.reactive.function.server.router

@Configuration
class ApiRouter(
    private val apiHandler: ApiHandler
) {
    @Bean
    fun apiRoutes() =
        nest(path("api"),
            router {
                GET("products/{prodNo}", apiHandler::getProduct)
                GET("products/{prodNo}/employee", apiHandler::getEmployee)
                GET("deals/{dealNo}/products", apiHandler::getProducts)
                GET("deals/{dealNo}/employee", apiHandler::getProductsAndEmployee)
                GET("products", apiHandler::getPagingProducts)
            }
        )
}