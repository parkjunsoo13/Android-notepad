package com.example.notepad_line;

public class Memo {

    private int seq;
    private int isdone;
    private String titletext;
    private String maintext;
    private String datetext;


    public Memo(String maintext, String datetext, String titletext, int isdone) {
        this.maintext = maintext;
        this.datetext = datetext;
        this.isdone = isdone;
        this.titletext=titletext;
    }

    public Memo(int seq, String maintext, String datetext, String titletext, int isdone) {
        this.seq = seq;
        this.maintext = maintext;
        this.datetext = datetext;
        this.titletext = titletext;
        this.isdone = isdone;
    }

    public int getSeq() { return seq; }

    public void setSeq(int seq) { this.seq = seq; }

    public String getTitletext() { return titletext; }

    public void setTitletext(String titletext) { this.titletext = titletext; }

    public String getMaintext() {
        return maintext;
    }

    public void setMaintext(String maintext) {
        this.maintext = maintext;
    }

    public String getDatetext() { return datetext; }

    public void setDatetext(String datetext) {
        this.datetext = datetext;
    }

    public int getIsdone() {
        return isdone;
    }

    public void setIsdone(int isdone) {
        this.isdone = isdone;
    }
}
