package com.example.simple.repository

import com.example.simple.domain.entity.Prod
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface ProdRepository : ReactiveCrudRepository<Prod, Long> {
    fun findAllByAndMdEmpNoGreaterThan(page: Pageable, mdEmpNo: Long = 0): Flux<Prod>

    fun countByAndMdEmpNoGreaterThan(mdEmpNo: Long = 0): Mono<Long>
}