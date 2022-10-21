package com.example.assignment.model;

public class Music {
    private String tenBaiHat;
    private int song;

    public Music() {
    }

    public Music(String tenBaiHat, int song) {
        this.tenBaiHat = tenBaiHat;
        this.song = song;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
    }

    public int getSong() {
        return song;
    }

    public void setSong(int song) {
        this.song = song;
    }
}
