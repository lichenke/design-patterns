package org.itstack.demo.design.proxydemo.staticproxy;

public class Teacher implements ITeacher{
    @Override
    public void teach() {
        System.out.println("开始上课");
    }
}
