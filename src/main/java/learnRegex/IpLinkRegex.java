package learnRegex;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpLinkRegex {

    private static String path = "iplink.txt";

    private final static Pattern patInfo = Pattern.compile("\\d+:\\s+(\\w+):\\s+\\<(.*?)\\>(.*?)(([0-9a-f]{2}:){5}[0-9a-f]{2})", Pattern.DOTALL);
    private final static Pattern PAT_MASTER = Pattern.compile("[\\s\\S]+master\\s+(br\\d+)[\\s\\S]+");

    public static void main(String[] args) throws Exception {
        File file = new File(path);
        FileInputStream fi = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        try {
            fi.read(data);
        } finally {
            fi.close();
        }
        String iplink = new String(data);

        Map<String, Map<String, Object>> infoMap = new HashMap<String, Map<String, Object>>();

        Matcher mat = patInfo.matcher(iplink);


        int i = 0;
        while (mat.find()) {
            i++;
            Map<String, Object> attrMap = new HashMap<String, Object>();

            assert mat.groupCount() == 5;

            String name = mat.group(1);

            attrMap.put("state", "enen");
            attrMap.put("mac", mat.group(4)); // mac

            System.out.println("group 1: " + mat.group(1));
            System.out.println("group 2: " + mat.group(2));
            System.out.println("group 3: " + mat.group(3));
            System.out.println("group 4: " + mat.group(4));
            System.out.println("group 5: " + mat.group(5));
            System.out.println();

            infoMap.put(name, attrMap);
        }
        System.out.println(i);
    }

}
