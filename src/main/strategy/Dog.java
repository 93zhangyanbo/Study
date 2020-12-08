package main.strategy;

/**
 * @Description:
 * @Auther:ZhangYanBo
 * @Date:2020-12-08 23:20
 */
public class Dog {
    private int food;

    public Dog(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
