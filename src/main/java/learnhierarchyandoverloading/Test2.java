package learnhierarchyandoverloading;

/**
 * <b>output:</b> <br/>
 * test B <br/>
 * I am B <br/>
 * 备注：B是一个A，所以可以编译成功，应该是编译器帮助将指向B的引用做了一个转换？
 */
public class Test2 {

    public static void main(String[] args) {

        test(new B());

    }

    public static void test(A a) {
        System.out.println("test A");
        a.whoAmI();
    }

}

