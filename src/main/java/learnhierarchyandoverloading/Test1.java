package learnhierarchyandoverloading;

/**
 * <b>output:</b> <br/>
 * test B <br/>
 * I am B <br/>
 *
 * ��ע�����õ�������B������ָ��Ķ���Ҳ��B��ʵ��������ƥ�䵽test(B b)������B�ķ���
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

