package org.itstack.demo.design.proxydemo.dynamicproxy;

import java.lang.reflect.Proxy;

public class Client {

    public static void main(String[] args) {
        // 目标对象
        ITeacher teacher = new Teacher();

        // 代理对象
        ITeacher teacherProxy = (ITeacher) Proxy.newProxyInstance(teacher.getClass().getClassLoader(), teacher.getClass().getInterfaces(), (proxy, method, args1) -> {
            String name = method.getName();
            Object res;
            if ("teach".equals(name)) {
                System.out.println("上课前点名");
                res = method.invoke(teacher, args1);
                System.out.println("下课后布置作业");
            } else {
                res = method.invoke(teacher, args1); // 除了teach方法，其它方法都不进行增强。只用一行代码就解决了静态代理需要改一堆文件的问题
            }
            return res;
        });
        teacherProxy.coach();


// jdk11不能用
//        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{ITeacher.class});
//        try (FileOutputStream fos = new FileOutputStream("/Users/lichenke/Desktop/$Proxy0.class")) {
//            fos.write(bytes);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }


    }
}
