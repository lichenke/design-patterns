package org.itstack.demo.singleton.pojo;

public class Company {

    private String name;

    public Company(String name) {
        this.name = name;
    }


    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
