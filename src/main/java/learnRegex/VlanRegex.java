package learnRegex;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VlanRegex {

    private static String path = "vlan.conf";
    private static String savepath = "vlan.bk";

    private final static Pattern pat = Pattern.compile("(auto\\s\\w+[^\\n]+\\n)|(iface[^\\n]+(\\n[ \t]+\\w+[^\\n]*)*)");

    public static void main(String[] args) throws Exception {
        File file = new File(path);
        FileInputStream fi = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        try {
            fi.read(data);
        } finally {
            fi.close();
        }
        String vlancfg = new String(data);

        Set<String> autoSet = new HashSet<String>();

        List<Map<String, Object>> datalist = new LinkedList<>();

        Matcher mat = pat.matcher(vlancfg);

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

                    if ("iface".equals(parts[0])) {
                        // 如果是iface行，将eth*放入NET_NAME，其他后续信息放入NET_NAME_EXT
                        dm.put(TbVlan.IFACE.name, parts[1]);
                        dm.put(TbVlan.VLANID.name, parts[1].split("\\.")[1]);
                        dm.put(TbVlan.NET_NAME_EXT.name, StringUtils.join(parts, ' ', 2, parts.length));
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
                System.out.println();
                datalist.add(dm);
            }
        }

        save(datalist);

        System.out.println(i);


    }

    public static void save(List<Map<String, Object>> data) throws IOException {

        File file = new File(savepath);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fo = new FileOutputStream(file);
        StringBuilder s = new StringBuilder();
        for(Map<String, Object> map : data) {
            s.append("auto ").append(map.get(TbVlan.IFACE.name)).append("\n");
            s.append("\t").append("iface ").append(map.get(TbVlan.IFACE.name)).append(" ").append(map.get(TbVlan.NET_NAME_EXT.name)).append("\n");
            s.append("\t").append("address ").append(map.get(TbVlan.ADDRESS.name)).append("\n");
            s.append("\t").append("netmask ").append(maskNum2Ip((int)map.get(TbVlan.NETMASK.name))).append("\n");
            s.append("\t").append("network ").append(map.get(TbVlan.NETWORK.name)).append("\n");
            s.append("\t").append("broadcast ").append(map.get(TbVlan.BROADCAST.name)).append("\n");
            s.append("\t").append("mtu ").append(map.get(TbVlan.MTU.name)).append("\n\n");
        }

        fo.write(s.toString().getBytes());
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

    private static String maskNum2Ip(int length) {

        if(length == 0) {
            return "0.0.0.0";
        }

        int mask = -1 << (32 - length);
        int partsNum = 4;
        int bitsOfPart = 8;
        int maskParts[] = new int[partsNum];
        int selector = 0x000000ff;

        for (int i = 0; i < maskParts.length; i++) {
            int pos = maskParts.length - 1 - i;
            maskParts[pos] = (mask >> (i * bitsOfPart)) & selector;
        }

        String result = "";
        result = result + maskParts[0];
        for (int i = 1; i < maskParts.length; i++) {
            result = result + "." + maskParts[i];
        }
        return result;
    }
}
