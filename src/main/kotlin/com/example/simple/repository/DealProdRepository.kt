package com.example.simple.repository

import com.example.simple.domain.entity.DealProd
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface DealProdRepository : ReactiveCrudRepository<DealProd, Long> {
    fun findByDealNo(dealNo: Long): Flux<DealProd>
}