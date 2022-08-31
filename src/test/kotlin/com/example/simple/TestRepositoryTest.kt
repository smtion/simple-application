package com.example.simple

import com.example.simple.repository.TestRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import reactor.test.StepVerifier

@SpringBootTest
class TestRepositoryTest(
    @Autowired private val repo: TestRepository
) {

    @Test
    fun writeTest() {
        StepVerifier.create(repo.save(com.example.simple.domain.entity.Test(null, "a", "desc")))
            .assertNext {
                println(it)
            }
            .verifyComplete()
    }

    @Test
    fun readTest() {
        StepVerifier.create(repo.findById(1))
            .assertNext {
                println(it)
            }
            .verifyComplete()
    }
}