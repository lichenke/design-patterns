package org.itstack.demo.design.test.simplefactory;

public class Test {

    public static void main(String[] args) {
        Iphone phone1 = PhoneFactory.createPhone_(ApplePhone.class);
        System.out.println(phone1.name());
        Iphone phone2 = PhoneFactory.createPhone(HuaweiPhone.class);
        System.out.println(phone2.name());
    }
}
