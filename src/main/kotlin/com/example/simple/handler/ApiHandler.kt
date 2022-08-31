package com.example.simple.handler

import com.example.simple.dto.ProdDto
import com.example.simple.dto.ProdEmployeeDto
import com.example.simple.service.ApiService
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@Component
class ApiHandler(
    private val apiService: ApiService
) {
    fun getProduct(req: ServerRequest): Mono<ServerResponse>
        // TODO

    fun getEmployee(req: ServerRequest): Mono<ServerResponse> =
        ok().body(
            // TODO
        )

    fun getProducts(req: ServerRequest): Mono<ServerResponse> =
        ok().body(
            // TODO
        )

    fun getProductsAndEmployee(req: ServerRequest): Mono<ServerResponse> =
        ok().body(
            // TODO
        )

    fun getPagingProducts(req: ServerRequest): Mono<ServerResponse> {
        // TODO
    }
}