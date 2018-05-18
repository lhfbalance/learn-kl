package learnhierarchyandoverloading;

/**
 * <b>output:</b> <br/>
 * test A <br/>
 * I am B <br/>
 * ��ע��obj��һ��A���������ͣ���ˣ�����ȥ��test(A a)�������test����ֻ����������õ����ͣ�������ȥ�����������ָ��Ķ�����A����Ķ���<br/>
 * ������Ϊʲô�����I am ������Ȼ����Ϊoverride����̬��ԭ��
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
