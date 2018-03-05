/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnDate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author LouHF
 *
 */
public class DateFormatTest {
  
  public static void main(String[] args) throws Exception {
    DateFormat mDateFormatMinutes = new SimpleDateFormat("yyyyMMddHHmm");
    DateFormat mDateFormatSeconds = new SimpleDateFormat("yyyyMMddhhmmss'Z'");//ע�⣺HH��ʹ��24Сʱ�ƣ�hh��ʹ��12Сʱ��
    //mDateFormatSeconds.setTimeZone(TimeZone.getTimeZone("GMT"));
    
    System.out.println(mDateFormatSeconds.format(new Date()));
    
    Date date = mDateFormatSeconds.parse("20170510154200Z");
    System.out.println(date);
    
    
//    String[] timeZones = TimeZone.getAvailableIDs();
//    for(String string : timeZones) {
//      System.out.println(string);
//    }
    
  }

}
