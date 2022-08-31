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
    fun getProduct(prodNo: Long): Mono<Prod> =
        prodRepository.findById(prodNo)
            .switchIfEmpty { Mono.error(ResponseStatusException(HttpStatus.NOT_FOUND)) }

    fun getEmployee(prodNo: Long): Mono<Employee> =
        getProduct(prodNo)
            .flatMap {
                employeeRepository.findById(it.mdEmpNo)
            }

    fun getProducts(dealNo: Long): Flux<Prod> =
        dealProdRepository.findByDealNo(dealNo)
            .map { it.prodNo }
            .collectList()
            .flatMapMany { prodRepository.findAllById(it) }

    fun getProductsAndEmployee(dealNo: Long): Flux<Pair<Prod, Employee?>> =
        getProducts(dealNo)
            .collectList()
            .flatMap { products: List<Prod> ->
                val empNos: List<Long> = products.map(Prod::mdEmpNo).distinct()
                employeeRepository.findAllById(empNos)
                    .collectList()
                    .map { mds ->
                        val mdMap: Map<Long, Employee> = mds.associateBy(Employee::empNo)

                        products.map { product ->
                            Pair(product, mdMap[product.mdEmpNo])
                        }
                    }
            }
            .flatMapIterable { it }

    fun getProducts(page: PageRequest): Mono<PageImpl<Prod>> =
        prodRepository.findAllByAndMdEmpNoGreaterThan(page)
            .collectList()
            .zipWith(prodRepository.countByAndMdEmpNoGreaterThan())
            .map { PageImpl(it.t1, page, it.t2 ) }
}
















