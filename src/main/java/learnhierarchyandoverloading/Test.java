package learnhierarchyandoverloading;

/**
 * <b>output:</b> <br/>
 * test A <br/>
 * I am B <br/>
 * 备注：obj是一个A的引用类型，因此，它会去找test(A a)，在这里，test函数只关心这个引用的类型，它不会去关心这个引用指向的对象是A以外的东西<br/>
 * 而至于为什么会输出I am ，那自然是因为override，多态的原因
 */
public class Test {

    public static void main(String[] args) {

        A obj = new B();
        test(obj);

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

class A {
    public void whoAmI() {
        System.out.println("I am A");
    }

}

class B extends A {
    public void whoAmI() {
        System.out.println("I am B");
    }
}
