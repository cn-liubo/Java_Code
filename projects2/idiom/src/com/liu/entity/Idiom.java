package com.liu.entity;

public class Idiom {
    private int id;
    private String pinyinE;
    private String pinyinS;
    private String value;
    private String wordE;
    private String wordS;
    private String paraphrase;

    public Idiom() {
    }

    public Idiom(int id, String pinyinE, String pinyinS, String value, String wordE, String wordS, String paraphrase) {
        this.id = id;
        this.pinyinE = pinyinE;
        this.pinyinS = pinyinS;
        this.value = value;
        this.wordE = wordE;
        this.wordS = wordS;
        this.paraphrase = paraphrase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPinyinE() {
        return pinyinE;
    }

    public void setPinyinE(String pinyinE) {
        this.pinyinE = pinyinE;
    }

    public String getPinyinS() {
        return pinyinS;
    }

    public void setPinyinS(String pinyinS) {
        this.pinyinS = pinyinS;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getWordE() {
        return wordE;
    }

    public void setWordE(String wordE) {
        this.wordE = wordE;
    }

    public String getWordS() {
        return wordS;
    }

    public void setWordS(String wordS) {
        this.wordS = wordS;
    }

    public String getParaphrase() {
        return paraphrase;
    }

    public void setParaphrase(String paraphrase) {
        this.paraphrase = paraphrase;
    }
}
