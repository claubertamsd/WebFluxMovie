package com.crud.reactive.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Document
public class Movie {
    @Id
    private String id;
    private String title;

    private String description;
    private int year;
    private Map<String, Availables> avaliacoes = new HashMap<>();

    public Movie() {
    }

    public Movie(String id, String title, String description, int year, Map<String, Availables> avaliacoes) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.year = year;
        this.avaliacoes = avaliacoes;
    }

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

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", avaliacoes=" + avaliacoes +
                '}';
    }
}