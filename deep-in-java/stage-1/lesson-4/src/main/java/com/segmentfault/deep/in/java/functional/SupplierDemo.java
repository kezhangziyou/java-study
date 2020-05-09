package com.segmentfault.deep.in.java.functional;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 * 提供类型，传递一段函数，返回函数返回的类型
 * @author zhangke
 */
public class SupplierDemo {

    public static void main(String[] args) {

        Supplier<Long> supplier = getLong();

        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return getHelloWorld();
            }
        };

        Callable<String> callable2 = SupplierDemo::getHelloWorld;


    }

    public static String getHelloWorld() {
        return "Hello,World";
    }

    public static Supplier<Long> getLong() {
//        return () -> {
//            return System.currentTimeMillis();
//        };
        return System::currentTimeMillis;
    }
}