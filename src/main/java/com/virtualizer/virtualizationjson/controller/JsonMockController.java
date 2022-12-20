package com.virtualizer.virtualizationjson.controller;

import com.virtualizer.virtualizationjson.JsonMockDTO.JsonMockDTO;
import com.virtualizer.virtualizationjson.model.JsonMock;
import com.virtualizer.virtualizationjson.repository.JsonMockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JsonMockController {

    @Autowired
    private JsonMockRepository jsonMockRepository;

    @GetMapping("/")
    public List<JsonMock> getAll() {
        List<JsonMock> jsonMockList = jsonMockRepository.findAll();
        return jsonMockList;
    }

    @GetMapping("/{name}")
    public ResponseEntity<JsonMock> findJson(@PathVariable String name) {
      JsonMock jsonFound = jsonMockRepository.findByName(name);
        if(jsonFound != null) {
            return ResponseEntity.ok(jsonFound);
        }

        return ResponseEntity.notFound().build();
    }


    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrar(@RequestBody JsonMock form) {

        JsonMock jsonMock = new JsonMock(form);
        jsonMockRepository.save(jsonMock);
        return ResponseEntity.ok(jsonMock);
    }
}
