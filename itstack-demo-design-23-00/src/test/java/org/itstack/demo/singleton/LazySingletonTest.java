package org.itstack.demo.singleton;


import com.alibaba.fastjson.JSON;
import org.itstack.demo.singleton.pojo.Company;
import org.junit.Test;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LazySingletonTest {

    @Test
    public void testLazySingleton1() {
        for (int i = 0; i < 20; i++) {
            // 存在多线程问题
            new Thread(() -> System.out.println(LazySingleton01.getInstance())).start();
        }
    }

    @Test
    public void testLazySingleton2() {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> System.out.println(LazySingleton02.getInstance())).start();
        }
    }

    @Test
    public void testEnumSingleton() {
        EnumSingleton.INSTANCE.setName("lck");
        System.out.println(EnumSingleton.INSTANCE.getName());
    }

    @Test
    public void testContainerSingleton() {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> System.out.println(ContainerSingleton.getInstance("org.itstack.demo.singleton.pojo.Company"))).start();

        }
        for (int i = 0; i < 20; i++) {
            new Thread(() -> System.out.println(ContainerSingleton.getInstance("org.itstack.demo.singleton.pojo.Person"))).start();
        }
    }

    @Test
    public void destroySingleton1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        StaticInnerClassSingleton instance = StaticInnerClassSingleton.getInstance();
        // 获取到构造器，是private的
        Constructor<StaticInnerClassSingleton> con = StaticInnerClassSingleton.class.getDeclaredConstructor();
        // 强制设置为可以访问
        con.setAccessible(true);
        StaticInnerClassSingleton instance1 = con.newInstance();
        System.out.println(instance1);
        System.out.println(instance);
        System.out.println(instance1 == instance);
    }

    @Test
    public void destroySingleton2() {
        LazySingleton03 instance1 = LazySingleton03.getInstance();
        // 使用Fastjson序列化再反序列化后，可以new出新的对象
        String jsonString = JSON.toJSONString(instance1);
        LazySingleton03 instance2 = JSON.parseObject(jsonString, LazySingleton03.class);
        System.out.println(instance1);
        System.out.println(instance2);

        // 使用ObjectOutputStream序列化再反序列化后，也可以new出新的对象（单例类需要实现Serializable接口）
        LazySingleton03 instance3 = LazySingleton03.getInstance();
        Path path = Paths.get("/Users/lichenke/Desktop/x.data");
        LazySingleton03 instance4;
        try (OutputStream os = Files.newOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(os);
             InputStream is = Files.newInputStream(path);
             ObjectInputStream ois = new ObjectInputStream(is)) {
            oos.writeObject(instance3);
            oos.flush();
            instance4 = (LazySingleton03)ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(instance3);
        System.out.println(instance4);
    }


}