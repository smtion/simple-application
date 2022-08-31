package com.example.simple.dto

import com.example.simple.domain.entity.Employee
import com.example.simple.domain.entity.Prod

data class ProdEmployeeDto(
    val prodNm: String,
    val empNm: String?,
) {
    constructor(pair: Pair<Prod, Employee?>): this(
        pair.first.prodNm,
        pair.second?.empNm
    )
}
