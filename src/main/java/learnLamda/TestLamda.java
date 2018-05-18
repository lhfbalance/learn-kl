package learnLamda;

public class TestLamda {

    public static void main(String[] args) {

        //e1:
        new Thread(() -> {
            System.out.println("1234");
        }).start();

        //e2
        Manager m = new Manager();
        m.addListener((e) -> {
            System.out.println(e.getName());
        });
        new Event("test").notice(m);
    }

}
