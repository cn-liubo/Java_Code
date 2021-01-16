package com.liu.entity;

public class Book {
    private int id;
    private String bookName;
    private int price;
    private int number;

    public Book() {
    }

    /*public Book(int id, String bookName, int number) {
        this.id = id;
        this.bookName = bookName;
        this.number = number;
    }*/

    public Book(int id, String bookName, int price, int number) {
        this.id = id;
        this.bookName = bookName;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
