package com.example.simple.repository

import com.example.simple.domain.entity.Test
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TestRepository : ReactiveCrudRepository<Test, Long>