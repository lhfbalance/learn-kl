package learnJavaFunctional;

import java.util.Random;

public class Bean1 {

    int id;

    Bean1() {
        this.id = new Random().nextInt(100);
    }

    static Bean1 createBean() {
        return new Bean1();
    }

    @Override
    public String toString() {
        return "i am " + id;
    }
}
