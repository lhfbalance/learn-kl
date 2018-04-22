package learnClassLoader;

import java.net.URL;

public class MyClassLoad {
    
    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(Object.class.getClassLoader());
        System.out.println(Boolean.class.getClassLoader());

        System.out.println(MyClassLoad.class.getPackage().getName());
        System.out.println(MyClassLoad.class.getName());

        System.out.println(MyClassLoad.class.getResource("/"));//��classpathΪ��
        System.out.println(MyClassLoad.class.getResource(""));//����������class���ڵİ�

        System.out.println(MyClassLoad.class.getResource("/learnClassLoader/res"));//��classpathΪ��
        System.out.println(MyClassLoad.class.getResource("res"));//����������class���ڵİ�

        System.out.println(MyClassLoad.class.getClassLoader().getResource("/"));
        System.out.println(MyClassLoad.class.getClassLoader().getResource("/"));
    }

}
