package org.itstack.demo.design.test.simplefactory;

public class PhoneFactory {

    public static Iphone createPhone(Class<? extends Iphone> phone) {
        try {
            return phone.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("手机创建失败", e);
        }
    }

    public static <T extends Iphone> T createPhone_(Class<T> phone) {
        try {
            return phone.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("手机创建失败", e);
        }
    }
}
