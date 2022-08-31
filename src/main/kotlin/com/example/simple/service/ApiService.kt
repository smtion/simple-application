package com.example.simple.service

import com.example.simple.domain.entity.Employee
import com.example.simple.domain.entity.Prod
import com.example.simple.repository.DealProdRepository
import com.example.simple.repository.EmployeeRepository
import com.example.simple.repository.ProdRepository
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.switchIfEmpty

@Service
class ApiService(
    private val dealProdRepository: DealProdRepository,
    private val prodRepository: ProdRepository,
    private val employeeRepository: EmployeeRepository,
) {
    fun getProduct(prodNo: Long): Mono<Prod>
        // TODO

    fun getEmployee(prodNo: Long): Mono<Employee>
        // TODO

    fun getProducts(dealNo: Long): Flux<Prod>
        // TODO

    fun getProductsAndEmployee(dealNo: Long): Flux<Pair<Prod, Employee?>>
        // TODO

    fun getProducts(page: PageRequest): Mono<PageImpl<Prod>>
        // TODO
}
















