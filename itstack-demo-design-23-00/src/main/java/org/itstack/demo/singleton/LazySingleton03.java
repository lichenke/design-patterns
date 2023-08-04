package org.itstack.demo.singleton;

/**
 * @author LiChenke
 **/
public class LazySingleton03 {

    private static volatile LazySingleton03 instance;

    private LazySingleton03() {

    }

    public static LazySingleton03 getInstance() {
        if (instance == null) {
            synchronized (LazySingleton03.class) {
                if (instance == null) {
                    instance = new LazySingleton03();
                }
            }
        }
        return instance;
    }
}
