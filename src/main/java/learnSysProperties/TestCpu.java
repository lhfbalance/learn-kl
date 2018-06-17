package learnSysProperties;

public class TestCpu {

    public static void main(String[] args) {
        System.out.println("cpu:");
        System.out.println(Runtime.getRuntime().availableProcessors());

//        System.out.println(System.getProperties());
        System.out.println(System.getProperty("ssl"));
    }

}
