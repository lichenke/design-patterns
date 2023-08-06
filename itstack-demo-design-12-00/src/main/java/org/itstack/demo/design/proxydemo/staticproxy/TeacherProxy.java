package org.itstack.demo.design.proxydemo.staticproxy;

public class TeacherProxy implements ITeacher {

    private final Teacher teacher;

    public TeacherProxy(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public void teach() {
        System.out.println("上课前点名");
        teacher.teach();
        System.out.println("下课后布置作业");
    }
}
