package com.virtualizer.virtualizationjson.model;

import com.virtualizer.virtualizationjson.JsonMockDTO.JsonMockDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;
import java.util.stream.Collectors;

@Entity
public class JsonMock {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String json;

    public JsonMock() {}
    public JsonMock(JsonMock jsonMock) {
        this.name = jsonMock.getName();
        this.json = jsonMock.getJson();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }


}
