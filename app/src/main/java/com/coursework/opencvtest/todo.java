package com.coursework.opencvtest;

public class  todo {

    private int userID;
    private int id;
    private String title;
    private boolean completed;

    public todo(int userID, int id, String title, boolean completed) {
        this.userID = userID;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public todo(int userID, String title, boolean completed) {
        this.userID = userID;
        this.title = title;
        this.completed = completed;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String  toString() {
        return "todo{" +
                "userID=" + userID +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
