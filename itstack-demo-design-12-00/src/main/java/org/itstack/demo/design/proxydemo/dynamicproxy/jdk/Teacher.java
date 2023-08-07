package org.itstack.demo.design.proxydemo.dynamicproxy.jdk;

public class Teacher implements ITeacher {
    @Override
    public void teach() {
        System.out.println("开始上课");
    }

    @Override
    public void coach() {
        System.out.println("开始辅导");
    }
}
