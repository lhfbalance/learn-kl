package learnhierarchyandoverloading;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TestOverload {

    public static void sayhello(Iterable iterable) {
        System.out.println("hello iterable");
    }

    public static void sayhello(Collection collection) {
        System.out.println("hello collection");
    }

    public static void sayhello(Set set) {
        System.out.println("hello set");
    }

    /**
     * Error:(26, 9) java: ��sayhello�����ò���ȷ
     * learnhierarchyandoverloading.TestOverload �еķ��� sayhello(java.util.Set) �� learnhierarchyandoverloading.TestOverload �еķ��� sayhello(java.lang.Cloneable) ��ƥ��
     * @param cloneable
     */
//    public static void sayhello(Cloneable cloneable) {
//        System.out.println("hello cloneable");
//    }

    public static void main(String[] args) {
        sayhello(new HashSet());
    }

}
