package learnhierarchyandoverloading;

/**
 * <b>output:</b> <br/>
 * test B <br/>
 * I am B <br/>
 * ��ע��B��һ��A�����Կ��Ա���ɹ���Ӧ���Ǳ�����������ָ��B����������һ��ת����
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

