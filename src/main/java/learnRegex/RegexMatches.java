package learnRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
    public static void main( String args[] ){

        // ��ָ��ģʽ���ַ�������
        String line = "This order was placed for QT3000! OK? " +
                "This order was placed for QT3000! OK?";
        String pattern = "(QT)(\\d+)(!)";

        // ���� Pattern ����
        Pattern r = Pattern.compile(pattern, Pattern.MULTILINE);

        // ���ڴ��� matcher ����
        Matcher m = r.matcher(line);
        while (m.find()) {
            System.out.println(m.groupCount());
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
            System.out.println();
        }
    }
}
