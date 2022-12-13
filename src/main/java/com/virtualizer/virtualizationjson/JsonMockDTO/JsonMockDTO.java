package com.virtualizer.virtualizationjson.JsonMockDTO;

import com.virtualizer.virtualizationjson.model.JsonMock;

import java.util.List;
import java.util.stream.Collectors;

public class JsonMockDTO {

    private String name;
    private String json;

    public JsonMockDTO(JsonMock jsonMock) {
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

    public static List<JsonMockDTO> converter(List<JsonMock> jsonMock) {
        return jsonMock.stream().map(JsonMockDTO::new).collect(Collectors.toList());
    }
}
