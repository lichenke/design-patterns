package org.itstack.demo.design.copy;

public class ShallowCopy {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.setAge(18);
        person.setName("lck");
        person.setCompany(new Company("ruijie"));
        System.out.println(person.getCompany().getName());

        Person person1 = person.clone();
        person1.getCompany().setName("bytedance");
        System.out.println(person1.getCompany().getName());
        System.out.println(person.getCompany().getName());
    }

}


class Person implements Cloneable {
    private String name;
    private int age;

    private Company company;

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        Person person = new Person();
        person.age = this.age;
        person.name = this.name;
        person.company = this.company.clone(); // 递归实现深拷贝
        return person;
    }
}


class Company implements Cloneable {
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Company clone() throws CloneNotSupportedException {
        return (Company) super.clone();
    }
}