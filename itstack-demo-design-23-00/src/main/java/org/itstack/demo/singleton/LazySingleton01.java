package org.itstack.demo.singleton;

/**
 * @author LiChenke
 **/
public class LazySingleton01 {

    /**
     * 1. 适用于单线程环境，不推荐
     *
     * 此方式在单线程的时候工作正常，但在多线程的情况下就有问题了。如果两个线
     * 程同时运行到判断instance是否为null的if语句，并且instance的确没有被
     * 创建时，那么两个线程都会创建一个实例，此时类型Singleton1就不再满足单
     * 例模式的要求了。
     */

    private static LazySingleton01 instance;

    private LazySingleton01() {}

    public static LazySingleton01 getInstance() {
        if (instance == null) {
            instance = new LazySingleton01();
        }
        return instance;
    }
}
