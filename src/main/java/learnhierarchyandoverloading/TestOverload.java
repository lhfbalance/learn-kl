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
     * Error:(26, 9) java: 对sayhello的引用不明确
     * learnhierarchyandoverloading.TestOverload 中的方法 sayhello(java.util.Set) 和 learnhierarchyandoverloading.TestOverload 中的方法 sayhello(java.lang.Cloneable) 都匹配
     * @param cloneable
     */
//    public static void sayhello(Cloneable cloneable) {
//        System.out.println("hello cloneable");
//    }

    public static void main(String[] args) {
        sayhello(new HashSet());
    }

}
