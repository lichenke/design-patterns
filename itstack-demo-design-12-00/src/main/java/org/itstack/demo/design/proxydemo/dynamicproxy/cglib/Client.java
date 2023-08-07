package org.itstack.demo.design.proxydemo.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class Client {

    public static void main(String[] args) {

        Teacher teacher = new Teacher();
        // 可以用Teacher接收返回的对象，Callback方法使用MethodInterceptor的接口实现
        Teacher teacherProxy = (Teacher) Enhancer.create(teacher.getClass(), (MethodInterceptor) (obj, method, args1, proxy) -> {
            String name = method.getName();
            Object res;
            if ("teach".equals(name)) {
                System.out.println("上课前点名");
                res = method.invoke(teacher, args1);
                System.out.println("下课后布置作业");
            } else {
                res = method.invoke(teacher, args1); // 除了teach方法，其它方法都不进行增强。
            }
            return res;
        });
        teacherProxy.coach();
        teacherProxy.teach();
    }
}
