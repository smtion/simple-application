package com.example.simple.domain.entity

import org.springframework.data.relational.core.mapping.Table

@Table
data class DealProd(
    val dealNo: Long,
    val prodNo: Long,
)
