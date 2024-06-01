package com.crud_api.demo.model;

import java.util.Map;

import lombok.Data;

@Data
public class User {
	private String id;
    private String name;
    private Map<String, Integer> subjectMarks;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getSubjectMarks() {
        return subjectMarks;
    }

    public void setSubjectMarks(Map<String, Integer> subjectMarks) {
        this.subjectMarks = subjectMarks;
    }

}
