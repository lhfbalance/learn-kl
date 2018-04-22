package learnRegex;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterfaceRegex {

    private static String path = "interfaces";

    private final static Pattern pat = Pattern.compile("(auto\\s[^br\\d+][^\\n]+\\n)|(iface[^\\n]+(\\n[ \t]+\\w+[^\\n]*)*)");
//    private final static Pattern pat = Pattern.compile("(iface[^\\n]+(\\n[ \t]+\\w+[^\\n]*)*)");

    Set<String> autoSet = new HashSet<String>();

    public static void main(String[] args) throws Exception {

        File file = new File(path);
        FileInputStream fi = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        try {
            fi.read(data);
        } finally {
            fi.close();
        }
        String interfaces = new String(data);

        Set<String> autoSet = new HashSet<String>();

        Matcher mat = pat.matcher(interfaces);

        int i = 0;

        matchWhile: while (mat.find()) {

            i++;

            assert mat.groupCount() == 3;
            String group1 = mat.group(1);
            group1 = group1 == null ? null : group1.trim();
            System.out.println("group 1: " + group1);
            System.out.println("group 2: " + mat.group(2));
            System.out.println("group 3: " + mat.group(3));
            System.out.println();
            String sAuto = mat.group(1);
            if (sAuto != null) {
                // 将auto后面的 eth0 eth0:1 ... 放入autoSet
                autoSet.addAll(Arrays.asList(sAuto.substring(4).trim().split("\\s+")));
            } else {
                // 添加数据
                Map<String, Object> dm = new HashMap<String, Object>();

                String sIface = mat.group(2);

                String[] lines = sIface.trim().split("\\n");
                if (lines.length == 0) {
                    continue;
                }
                for (String s : lines) {
                    String[] parts = s.trim().split("\\s+");
                    assert parts.length > 1;

                    if("iface".equals(parts[0])) {
                        dm.put("status", "已启用");
                    }

                    if ("iface".equals(parts[0])) {
                        // 如果是iface行，将eth*放入NET_NAME，其他后续信息放入NET_NAME_EXT
                        dm.put("iface", parts[1]);
                        dm.put("type", parts[1].contains(":") ? "虚拟" : "物理");
                        dm.put("ext", StringUtils.join(parts, ' ', 2, parts.length));
                    } else {
                        // 其他信息，[0] : [1~]
                        dm.put(parts[0], StringUtils.join(parts, ' ', 1, parts.length));
                    }
                }

                // 转换mask为num形式
                if (dm.containsKey("netmask")) {
                    dm.put("netmask", maskIp2Num((String)dm.get("netmask")));
                }

                System.out.println(dm);
            }
        }

        System.out.println(i);
    }

    private static Integer maskIp2Num(String ip) {
        if (ip == null || ip.isEmpty())
            return 0;
        String[] parts = ip.split("\\.");
        int ret = 0;
        for (String s : parts) {
            String binS = Integer.toBinaryString(Integer.parseInt(s));
            ret += StringUtils.countMatches(binS, "1");
        }
        return ret;
    }
}
