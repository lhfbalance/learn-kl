package learnResourceLoad;

public class ResourceLoad {
    
    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(Object.class.getClassLoader());
        System.out.println(Boolean.class.getClassLoader());

        System.out.println(ResourceLoad.class.getPackage().getName());
        System.out.println(ResourceLoad.class.getName());

        System.out.println(ResourceLoad.class.getResource("/"));//��classpathΪ��
        System.out.println(ResourceLoad.class.getResource(""));//����������class���ڵİ�

        System.out.println(ResourceLoad.class.getResource("/learnResourceLoad/res"));//��classpathΪ��
        System.out.println(ResourceLoad.class.getResource("res"));//����������class���ڵİ�

        System.out.println(ResourceLoad.class.getClassLoader().getResource("/"));
        System.out.println(ResourceLoad.class.getClassLoader().getResource("/"));
    }

}
