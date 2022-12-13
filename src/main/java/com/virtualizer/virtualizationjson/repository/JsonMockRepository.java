package com.virtualizer.virtualizationjson.repository;

import com.virtualizer.virtualizationjson.model.JsonMock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface JsonMockRepository extends JpaRepository<JsonMock, Long> {
}
