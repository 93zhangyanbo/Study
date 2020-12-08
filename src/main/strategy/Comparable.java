package main.strategy;

/**
 * @Description:
 * @Auther:ZhangYanBo
 * @Date:2020-12-08 23:14
 */
@FunctionalInterface
public interface Comparable<T> {
    int compareTo(T o1);

    default void m(){
        System.out.println("默认方法实现");
    }
}
