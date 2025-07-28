package com.zmq.fraud_awareness.models;

public class Article {
    private int id;
    private String title;
    private String content;
    private String category;
    private String date;

    public Article(int id, String title, String content, String category, String date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.date = date;
    }

    public Article(String title, String content, String category, String date) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.date = date;
    }

    // Getters and Setters
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }
}
