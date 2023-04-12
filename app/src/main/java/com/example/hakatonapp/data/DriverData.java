package com.example.hakatonapp.data;

public class DriverData {

    String name;
    String surname;
    String phone;
    String whereFrom;
    String where;
    String numCar;
    String car;
    String age;
    String price;
    String date;
    String mest;

    public DriverData() {
    }

    public DriverData(String name, String surname, String phone, String whereFrom, String where, String numCar, String car, String age, String price, String date, String mest) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.whereFrom = whereFrom;
        this.where = where;
        this.numCar = numCar;
        this.car = car;
        this.age = age;
        this.price = price;
        this.date = date;
        this.mest = mest;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getMest() {
        return mest;
    }

    public void setMest(String mest) {
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
