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
    fun getProduct(req: ServerRequest): Mono<ServerResponse> =
        ok().body(
            apiService.getProduct(req.pathVariable("prodNo").toLong())
                .map { ProdDto(it) }
        )

    fun getEmployee(req: ServerRequest): Mono<ServerResponse> =
        ok().body(
            apiService.getEmployee(req.pathVariable("prodNo").toLong())
        )

    fun getProducts(req: ServerRequest): Mono<ServerResponse> =
        ok().body(
            apiService.getProducts(req.pathVariable("dealNo").toLong())
                .map { ProdDto(it) }
        )

    fun getProductsAndEmployee(req: ServerRequest): Mono<ServerResponse> =
        ok().body(
            apiService.getProductsAndEmployee(req.pathVariable("dealNo").toLong())
                .map { ProdEmployeeDto(it) }
        )

    fun getPagingProducts(req: ServerRequest): Mono<ServerResponse> {
        val page: Int = req.queryParam("page").orElse("0").toInt()
        val size: Int = req.queryParam("size").orElse("10").toInt()
        val pageable = PageRequest.of(page, size)

        return ok().body(
            apiService.getProducts(pageable)
        )
    }
}