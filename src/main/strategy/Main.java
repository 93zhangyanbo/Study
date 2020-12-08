package main.strategy;

import java.util.Arrays;

/**
 * @Description:
 * @Auther:ZhangYanBo
 * @Date:2020-12-08 23:06
 * 策略模式
 */
public class Main {
    public static void main(String[] args) {
        Cat[] cats = {new Cat(3,3),new Cat(1,1),new Cat(5,5)};
        Dog[] dogs = {new Dog(6),new Dog(9),new Dog(3)};

        Sorter<Cat> sorter = new Sorter<>();
        sorter.sort(cats,(c1,c2)->{
            if(c1.getWeight() > c2.getWeight()) return 1;
            else if(c1.getWeight() < c2.getWeight()) return -1;
            return 0;
        });
        System.out.println(Arrays.toString(cats));
        Sorter<Dog> sorter2 = new Sorter<>();
        sorter2.sort(dogs,(d1,d2)->{
            if(d1.getFood() < d2.getFood()) return 1;
            else if (d1.getFood() > d2.getFood()) return -1;
            return 0;
        });
        System.out.println(Arrays.toString(dogs));
    }
}
