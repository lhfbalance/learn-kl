package learnhierarchyandoverloading;

/**
 * <b>output:</b> <br/>
 * test B <br/>
 * I am B <br/>
 *
 * 备注：引用的类型是B，引用指向的对象也是B的实例，所以匹配到test(B b)，调用B的方法
 */
public class Test1 {

    public static void main(String[] args) {

//        B obj = new B();
//        test(obj);
        test(new B());

    }

    public static void test(B b) {
        System.out.println("test B");
        b.whoAmI();
    }

    public static void test(A a) {
        System.out.println("test A");
        a.whoAmI();
    }

}

