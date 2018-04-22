package learnClassLoader;

import com.superafroman.utils.scanner.ClassScanner;
import kl.crypto.engine.CryptoEngineEnumer;
import kl.crypto.engine.ICryptoEngine;
import kl.crypto.engine.impl.SimpleFileEngine;

import java.util.List;

public class CryptoEngineLoader {

    public static void main(String[] args) {

        System.out.println("test CryptoEngineLoader");

        System.out.println("classpath: " + System.getProperty("java.class.path"));

        System.out.println("CryptoEngineLoader:");
        System.out.println(CryptoEngineLoader.class.getClassLoader());
        System.out.println();

        List<String> EngineNameList = CryptoEngineEnumer.getInstance().getEngineNameList();

        System.out.println("engine object load by reflect: ");
        if (EngineNameList.isEmpty()) {
            System.err.println("none of object load");
        }
        for (String name : EngineNameList) {
            System.out.println(name);
            ICryptoEngine engine = CryptoEngineEnumer.getInstance().getCryptoEngine(name);

            System.out.println(engine.getClass().getClassLoader());
        }

        System.out.println();

        System.out.println("CryptoEngineEnumer:");
        System.out.println(CryptoEngineEnumer.class.getClassLoader());

        System.out.println();

        System.out.println("ClassScanner:");
        System.out.println(ClassScanner.class.getClassLoader());

        System.out.println();

        System.out.println("engine object load by self");
        System.out.println("fileEngine:");
        System.out.println(SimpleFileEngine.class.getClassLoader());
        
    }

}
