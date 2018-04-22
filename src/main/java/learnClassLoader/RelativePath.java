package learnClassLoader;

import java.io.File;
import java.io.IOException;

public class RelativePath {

    public static void main(String[] args) {

        String envLocation = null;
        File directory = new File(".");

        try {
            envLocation = directory.getCanonicalPath();
        } catch (IOException var14) {
            ;
        }

        System.out.println(envLocation);
    }

}
