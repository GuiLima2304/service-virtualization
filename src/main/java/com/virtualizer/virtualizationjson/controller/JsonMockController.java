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

    @PutMapping("/{name}")
    public ResponseEntity<JsonMock> editJson(@PathVariable String name, @RequestBody JsonMock form) {
        JsonMock optional = jsonMockRepository.findByName(name);
        if(optional != null) {
            JsonMock newJson = form.update(optional.getId(), jsonMockRepository);
            jsonMockRepository.save(newJson);
            return ResponseEntity.ok(newJson);
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
