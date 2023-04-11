package com.example.hakatonapp.data;

public class DriverData {

    String name;
    String surname;
    int age;
    int mest;
    String price;
    String whereFrom;
    String where;
    String date;

    public DriverData(String name, String surname, int age, int mest, String price, String whereFrom, String where, String date) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.mest = mest;
        this.price = price;
        this.whereFrom = whereFrom;
        this.where = where;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMest() {
        return mest;
    }

    public void setMest(int mest) {
        this.mest = mest;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWhereFrom() {
        return whereFrom;
    }

    public void setWhereFrom(String whereFrom) {
        this.whereFrom = whereFrom;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
