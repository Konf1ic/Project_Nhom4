package com.example.web.model;


public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String name;
    private int age;
    private String phone_number;
    private String address;
    private double wage;
    private String position;
    private String description;


    public User(String username, String password, String email, String position) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.position = position;
    }

    public User() {
    }

    public User(int id, String username, String password, String email, String name, int age, String phone_number, String address, double wage, String position) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.age = age;
        this.phone_number = phone_number;
        this.address = address;
        this.wage = wage;
        this.position = position;
    }

    public User(int id, String username, String password, String email, String name, int age, String phone_number, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.age = age;
        this.phone_number = phone_number;
        this.address = address;
    }

    public User(int id, String username, String password, String email, int age, String phone_number, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.phone_number = phone_number;
        this.address = address;
    }

    public User(String username, String password, String email, int age, String phone_number, String address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.phone_number = phone_number;
        this.address = address;
    }

    public User(String username, String password, String email, String name, int age, String phone_number, String address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.age = age;
        this.phone_number = phone_number;
        this.address = address;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, String password, String email, String name, int age, String phone_number, String address, double wage) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.age = age;
        this.phone_number = phone_number;
        this.address = address;
        this.wage = wage;
    }

    public User(int id, String password, String email, String name, int age, String phone_number, String address, double wage) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.age = age;
        this.phone_number = phone_number;
        this.address = address;
        this.wage = wage;
    }

    public User(String username, String password, String email, String name, String position) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.position = position;
    }

    public User(String username, String password, String email, String name, int age, String phone_number, String address, double wage, String position) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.age = age;
        this.phone_number = phone_number;
        this.address = address;
        this.wage = wage;
        this.position = position;
    }

    public User(int id, String username, String password, String email, int age, String phone_number, String address, double wage, String position) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.phone_number = phone_number;
        this.address = address;
        this.wage = wage;
        this.position = position;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone_number='" + phone_number + '\'' +
                ", address='" + address + '\'' +
                ", wage=" + wage +
                ", position='" + position + '\'' +
                '}';
    }
}