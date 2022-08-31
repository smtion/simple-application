package com.example.simple.dto

import com.example.simple.domain.entity.Prod

data class ProdDto(
    val prodNm: String,
) {
    constructor(prod: Prod): this(
        prodNm = prod.prodNm
    )
}
