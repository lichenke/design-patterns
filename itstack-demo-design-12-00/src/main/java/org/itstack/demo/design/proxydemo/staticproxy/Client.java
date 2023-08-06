package org.itstack.demo.design.proxydemo.staticproxy;

public class Client {

    public static void main(String[] args) {
        // 目标类执行方法
        ITeacher teacher = new Teacher();
        teacher.teach();

        // 代理类执行同一个方法
        ITeacher teacherProxy = new TeacherProxy(new Teacher());
        teacherProxy.teach();
    }
}
