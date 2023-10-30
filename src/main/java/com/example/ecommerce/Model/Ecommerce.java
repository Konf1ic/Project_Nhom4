package com.example.ecommerce.Model;

public class Ecommerce
{
    private int id;
    private String username;
    private String password;
    private String email;
    private String name;
    private int age;
    private String phone_number;
    private String address;
    private Double wage;

    public Ecommerce(){}

    public Ecommerce(int id, String username, String password, String email, String name, int age, String phone_number, String address)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.age = age;
        this.phone_number = phone_number;
        this.address = address;
    }

    public Ecommerce(int id, String password, String email, String name, int age, String phone_number, String address, Double wage) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.age = age;
        this.phone_number = phone_number;
        this.address = address;
        this.wage = wage;
    }

    public Ecommerce(int id, String name, String password, String email, int age, String phone_number, String address)
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.age = age;
        this.phone_number = phone_number;
        this.address = address;
    }

    public Ecommerce(String username, String password, String email, int age, String phone_number, String address)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.phone_number = phone_number;
        this.address = address;
    }

    public Ecommerce(String username, String password, String email, String name, int age, String phoneNumber, String address)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name= name;
        this.age = age;
        this.phone_number = phoneNumber;
        this.address = address;
    }

    public Ecommerce(int id, String username, String password, String email, String name, int age, String phone_number, String address, Double wage) {
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

    public Ecommerce(String username, String password, String email, String name, int age, String phone_number, String address, Double wage) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.age = age;
        this.phone_number = phone_number;
        this.address = address;
        this.wage = wage;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getPhone_number()
    {
        return phone_number;
    }

    public void setPhone_number(String phone_number)
    {
        this.phone_number = phone_number;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }
}
