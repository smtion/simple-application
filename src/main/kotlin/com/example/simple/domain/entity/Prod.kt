package com.example.simple.domain.entity

import com.example.simple.domain.enumtype.SaleStatusType
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table
data class Prod(
    @Id
    val prodNo: Long,
    val prodNm: String,
    val partnerId: String,
    val mdEmpNo: Long,
    val saleStatus: SaleStatusType,
)
