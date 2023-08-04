package org.itstack.demo.singleton;

/**
 * @author LiChenke
 **/
public class StaticInnerClassSingleton {

        /**
         * 静态内部类方式，推荐
         *
         * 加载一个类时，其内部类不会同时被加载。一个类被加载，当且仅当其某个静态成员
         * （静态域、构造器、静态方法等）被调用时发生。 由lwg于在调用 getInstance()
         * 的时候，才会对单例进行初始化，而且通过反射，是不能从外部类获取内部类的属性的；
         * 由于静态内部类的特性，只有在其被第一次引用的时候才会被加载，所以可以保证其线程安全性。
         *
         * 总结：
         * 优势：兼顾了懒汉模式的内存优化（使用时才初始化）以及饿汉模式的安全性（不会被反射入侵）。
         * 劣势：需要两个类去做到这一点，虽然不会创建静态内部类的对象，但是其 Class 对象还是会被创建，而且是属于永久带的对象。
         *
         */
        private StaticInnerClassSingleton() {
            // 解决反射破坏，因为反射可以通过setAccessible强制调用私有的构造器
            if (SingletonHolder.instance != null) {
                throw new RuntimeException("不允许非法访问");
            }
        }

        public static StaticInnerClassSingleton getInstance() {
            return SingletonHolder.instance;
        }

        private static class SingletonHolder {
            private static final StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
        }
}
