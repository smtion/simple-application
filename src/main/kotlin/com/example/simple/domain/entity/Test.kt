package com.example.simple.domain.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table
data class Test(
    @Id
    val id: Long? = null,
    val name: String,
    val description: String,
)