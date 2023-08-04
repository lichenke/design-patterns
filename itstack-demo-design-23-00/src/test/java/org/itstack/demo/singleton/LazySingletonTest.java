package org.itstack.demo.singleton;


import org.junit.Test;

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


}