package com.example.simple.domain.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table
data class Employee(
    @Id
    val empNo: Long,
    val empNm: String,
)
