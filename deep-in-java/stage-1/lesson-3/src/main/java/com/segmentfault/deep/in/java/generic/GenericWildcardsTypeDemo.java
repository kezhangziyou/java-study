package com.segmentfault.deep.in.java.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class GenericWildcardsTypeDemo {

    public static void main(String[] args) {

        List<Number> numbers = new ArrayList<>();
        upperBoundedWildcards(numbers);
        unboundedWildcards(numbers);
        lowerBoundedWildcards(numbers);
    }

	/**
	 * 泛型的上界
	 * @param numbers
	 */
    private static void upperBoundedWildcards(List<Number> numbers) {
        // 泛型上界通配配型
        // Number -> Byte, Short , Integer, Long
        numbers.add(Byte.valueOf((byte) 1));
        numbers.add(Short.valueOf((short) 2));
        numbers.add(Integer.valueOf(3));
        numbers.add(Long.valueOf(4L));

        List<Byte> bytes = Arrays.asList((byte) 5);
        List<Short> shorts = Arrays.asList((short) 6);
        List<Integer> integers = Arrays.asList(7);

		// ? extends Number; List<Byte>,规定了上界
        numbers.addAll(bytes);
		// ? extends Number; List<Short>
        numbers.addAll(shorts);
		// ? extends Number; List<Integer>
        numbers.addAll(integers);

        // 被操作（处理）的对象，需要更为抽象类型，Number
        // 待整合（输入）的对象，可以是具体类型

        upperBoundedWildcardsDemo(numbers, System.out::println);
    }

	public static void upperBoundedWildcardsDemo(Iterable<? extends Number> iterable, Consumer<Object> consumer) {
		for (Object e : iterable) {
			consumer.accept(e);
		}

	}

	/**
	 *  泛型的下界
	 * @param numbers
	 */
	private static void lowerBoundedWildcards(List<Number> numbers) {
		lowerBoundedWildcardsDemo(numbers, numbers);
	}

	private static void lowerBoundedWildcardsDemo(List<? extends Number> producer, List<? super Number> consumer) {
		// PECS stands for producer(生产者)-extends, consumer(消费者)-super.
		// 读取数据（生产者）使用 extends
		for (Number number : producer) {

		}
		// 操作输出（消费者）使用 super
		consumer.add(1);
		consumer.add((short) 2);
	}

	/**
	 * 完全通配类型
	 * 在运行时与非统配泛型会出现方法签名冲突
	 * 然后完全通配类型，可以适配任意类型，比如集合
	 * 反而具体类型泛型会限制类型范围
	 * @param numbers
	 */
    private static void unboundedWildcards(List<Number> numbers) {

        unboundedWildcardsDemo(numbers);
    }



	/**
	 * 和方法unboundedWildcardsDemo的方法签名一样
	 * @param iterable
	 */
    public static void unboundedWildcardsDemo(Iterable<?> iterable) { // 泛型类型擦写，导致和下方法冲突
        for (Object e : iterable) {
            System.out.println(e);
        }
    }

//    public static void unboundedWildcardsDemo(Iterable<Object> iterable) {
//        for (Object e : iterable) {
//            System.out.unboundedWildcardsDemo(e);
//        }
//    }

}
