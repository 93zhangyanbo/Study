package main.strategy;

/**
 * @Description:
 * @Auther:ZhangYanBo
 * @Date:2020-12-08 23:27
 * 提供选择排序方法的一个类
 */
public class Sorter<T> {
    public void sort(T[] arr, Comparator<T> comparator){
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = comparator.compare(arr[i], arr[minPos]);
            }
            swap(arr,i,minPos);
        }
    }

    private void swap(T[] arr, int i, int minPos) {
        T temp = arr[i];
        arr[i] = arr[minPos];
        arr[minPos] = temp;
    }


}
