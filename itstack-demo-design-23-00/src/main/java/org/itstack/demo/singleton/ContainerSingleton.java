package org.itstack.demo.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {

    private ContainerSingleton() {

    }

    private static final Map<String, Object> ioc = new ConcurrentHashMap<>();

    public static Object getInstance(String className) {
        Object instance;
        if (!ioc.containsKey(className)) {
            synchronized (ContainerSingleton.class) {
                if (!ioc.containsKey(className)) {
                    try {
                        instance = Class.forName(className).getDeclaredConstructor().newInstance();
                        ioc.put(className, instance);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    instance = ioc.get(className);
                }
            }
            return instance;
        } else {
            return ioc.get(className);
        }
    }
}


