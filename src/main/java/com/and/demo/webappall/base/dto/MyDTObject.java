package com.and.demo.webappall.base.dto;

public class MyDTObject {
    String name;
    String title;
    int score;
    String gender;


    public MyDTObject(String name, String title, int score, String gender){
        this.name = name;
        this.title = title;
        this.score = score;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
