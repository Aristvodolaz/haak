package com.example.hakatonapp.data;

public class UserData {
    String name;
    String surname;
    String age;
    String city;
    String phone;
    String email;

    public UserData() {

    }

    public UserData(String name, String surname, String age, String city, String phone, String email) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.phone = phone;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
}
