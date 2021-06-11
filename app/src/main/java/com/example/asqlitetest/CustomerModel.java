package com.example.asqlitetest;

public class CustomerModel {

    private int id;
    private String name;
    private int age;
    private boolean isActiv;

    public CustomerModel() {
    }

    public CustomerModel(int id, String name, int age, boolean isActiv) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isActiv = isActiv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isActiv() {
        return isActiv;
    }

    public void setActiv(boolean activ) {
        isActiv = activ;
    }

    @Override
    public String toString() {
        return "CustomerModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isActiv=" + isActiv +
                '}';
    }
}
