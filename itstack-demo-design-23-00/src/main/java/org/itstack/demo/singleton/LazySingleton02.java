package org.itstack.demo.singleton;

/**
 * @author LiChenke
 **/
public class LazySingleton02 {

    private static LazySingleton02 instance;

    private LazySingleton02() {

    }

    public synchronized static LazySingleton02 getInstance() {
        if (instance == null) {
            instance = new LazySingleton02();
        }
        return instance;
    }
}
