package main.strategy;

/**
 * @Description:
 * @Auther:ZhangYanBo
 * @Date:2020-12-08 23:16
 */
@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2);
}
