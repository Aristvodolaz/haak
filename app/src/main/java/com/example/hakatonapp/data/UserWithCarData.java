package com.example.hakatonapp.data;

public class UserWithCarData {
    String name;
    String surname;
    int age;
    String city;
    String car_name;
    String car_num;
    int age_driver;
    String phone;
    String email;
    Boolean boolType;

    public UserWithCarData(String name, String surname, int age, String city,
                           String car_name, String car_num, int age_driver,
                           String phone, String email, Boolean boolType) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.car_name = car_name;
        this.car_num = car_num;
        this.age_driver = age_driver;
        this.phone = phone;
        this.email = email;
        this.boolType = boolType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getCar_num() {
        return car_num;
    }

    public void setCar_num(String car_num) {
        this.car_num = car_num;
    }

    public int getAge_driver() {
        return age_driver;
    }

    public void setAge_driver(int age_driver) {
        this.age_driver = age_driver;
    }

    public Boolean getBoolType() {
        return boolType;
    }

    public void setBoolType(Boolean boolType) {
        this.boolType = boolType;
    }
}
