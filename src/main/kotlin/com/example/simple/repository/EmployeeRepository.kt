package com.example.simple.repository

import com.example.simple.domain.entity.Employee
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeRepository : ReactiveCrudRepository<Employee, Long>