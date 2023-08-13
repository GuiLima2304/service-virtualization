package com.virtualizer.virtualizationjson.repository;

import com.virtualizer.virtualizationjson.model.JsonMock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

@EnableJpaRepositories
public interface JsonMockRepository extends JpaRepository<JsonMock, Long> {

    JsonMock findByName(String name);
}
