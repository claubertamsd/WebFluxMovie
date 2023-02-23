package com.crud.reactive.models;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Movie {
    private String id;
    private String title;

    private String description;
    private int year;
    private Map<String, Availables> avaliacoes = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Availables> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(Map<String, Availables> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

}