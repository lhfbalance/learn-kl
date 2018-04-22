package learnClassLoader;

public class WhichClassloader {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        NoanInterface obj1 = new Class1();

        NoanInterface obj2 = Class2.class.newInstance();

        System.out.println(WhichClassloader.class.getClassLoader());

        System.out.println(obj1.getClass().getClassLoader());

        System.out.println(obj2.getClass().getClassLoader());
    }

}
