package learnResourceLoad;

public class ResourceLoad {
    
    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(Object.class.getClassLoader());
        System.out.println(Boolean.class.getClassLoader());

        System.out.println(ResourceLoad.class.getPackage().getName());
        System.out.println(ResourceLoad.class.getName());

        System.out.println(ResourceLoad.class.getResource("/"));//以classpath为根
        System.out.println(ResourceLoad.class.getResource(""));//相对于已这个class所在的包

        System.out.println(ResourceLoad.class.getResource("/learnResourceLoad/res"));//以classpath为根
        System.out.println(ResourceLoad.class.getResource("res"));//相对于已这个class所在的包

        System.out.println(ResourceLoad.class.getClassLoader().getResource("/"));
        System.out.println(ResourceLoad.class.getClassLoader().getResource("/"));
    }

}
