package com.and.demo.webappall.base.dto;

public class UISettings {
    int highMark;
    int veryHighMark;

    public UISettings(int highMark, int veryHighMark) {
        this.highMark = highMark;
        this.veryHighMark = veryHighMark;
    }


    public int getVeryHighMark() {
        return veryHighMark;
    }

    public void setVeryHighMark(int veryHighMark) {
        this.veryHighMark = veryHighMark;
    }

    public int getHighMark() {
        return highMark;
    }

    public void setHighMark(int highMark) {
        this.highMark = highMark;
    }
}
