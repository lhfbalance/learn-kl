package learnClassLoader;

import java.net.URL;

public class MyClassLoad {
    
    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(Object.class.getClassLoader());
        System.out.println(Boolean.class.getClassLoader());

        System.out.println(MyClassLoad.class.getPackage().getName());
        System.out.println(MyClassLoad.class.getName());

        System.out.println(MyClassLoad.class.getResource("/"));//以classpath为根
        System.out.println(MyClassLoad.class.getResource(""));//相对于已这个class所在的包

        System.out.println(MyClassLoad.class.getResource("/learnClassLoader/res"));//以classpath为根
        System.out.println(MyClassLoad.class.getResource("res"));//相对于已这个class所在的包

        System.out.println(MyClassLoad.class.getClassLoader().getResource("/"));
        System.out.println(MyClassLoad.class.getClassLoader().getResource("/"));
    }

}
