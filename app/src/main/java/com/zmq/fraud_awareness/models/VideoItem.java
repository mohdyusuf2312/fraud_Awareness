package com.zmq.fraud_awareness.models;

public class VideoItem {
    private int id;
    private String title;
    private String filename;  // e.g., "upi_fraud_tips.mp4"
    private String description;

    public VideoItem(int id, String title, String filename, String description) {
        this.id = id;
        this.title = title;
        this.filename = filename;
        this.description = description;
    }

    public VideoItem(String title, String filename, String description) {
        this.title = title;
        this.filename = filename;
        this.description = description;
    }

    // Getters and Setters
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getFilename() { return filename; }

    public void setFilename(String filename) { this.filename = filename; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}
