package com.liu.entity;

public class BuyBook {
    private int id;
    private String bookName;
    private int totalPrice;
    private int number;

    public BuyBook() {
    }

    public BuyBook(int id, String bookName, int totalPrice, int number) {
        this.id = id;
        this.bookName = bookName;
        this.totalPrice = totalPrice;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
