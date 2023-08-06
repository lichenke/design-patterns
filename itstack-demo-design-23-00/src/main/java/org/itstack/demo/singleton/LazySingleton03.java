package org.itstack.demo.singleton;

import java.io.Serializable;

/**
 * @author LiChenke
 **/
public class LazySingleton03 implements Serializable {

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

    private Object readResolve() {
        return instance;
    }
}
