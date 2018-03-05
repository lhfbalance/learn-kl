/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package testString;

/**
 * @author LouHF
 *
 */
public class testByte2Int {

    public static void main(String[] args) {

      byte[] en = {0, 0, 74, 64, 'a', 'b', 'c', 'd', 'e', 0, 0, 0, 3, 'i', 'o', 'u',};
      for (int i = 0; i < en.length; i++) {
        System.out.println(en[i]);
      }
      //byte[] en2 = {0, 0, 74, -64};
      //int testLength = byte2int(en2);
      //System.out.println(testLength);
      String ens = new String(en);
      StringBuffer length = new StringBuffer(ens.substring(0, 4));
      byte[] ll = length.reverse().toString().getBytes();
      int firstLengtherror = byte2int(length.reverse().toString().getBytes());
      int firstLength = byte2int(ll);
      System.out.println("firstLength: " + firstLength);
      String first = ens.substring(4, 4 + firstLength);
      System.out.println(first + "  firstString: ");
      byte[] firstByte = first.getBytes();
      for (int i = 0; i < firstByte.length; i++) {
        System.out.print(firstByte[i]);
      }
      System.out.println();
      
      
      length = new StringBuffer(ens.substring(4 + firstLength, 8 + firstLength));
      int secondLength = byte2int(length.reverse().toString().getBytes());
      System.out.println("secondLength: " + secondLength);
      String Second = ens.substring(8 + firstLength);
      System.out.println(Second + "  secondString: ");
      byte[] secondByte = Second.getBytes();
      for (int i = 0; i < secondByte.length; i++) {
        System.out.print(secondByte[i]);
      }
    }

    public static int byte2intBig(byte[] res) {
       // 涓�涓猙yte鏁版嵁宸︾Щ24浣嶅彉鎴�0x??000000锛屽啀鍙崇Щ8浣嶅彉鎴�0x00??0000
      //byte[] res 鏄綉缁滃瓧鑺傚簭锛堝ぇ绔級
      int targets = (res[3] & 0xff) | ((res[2] << 8) & 0xff00) // | 鎸変綅鎴�
          | ((res[1] << 24) >>> 8) | (res[0] << 24);
      return targets;
    }
    public static int byte2int(byte[] res) {
      // 涓�涓猙yte鏁版嵁宸︾Щ24浣嶅彉鎴�0x??000000锛屽啀鍙崇Щ8浣嶅彉鎴�0x00??0000
     //byte[] res 鏄綉缁滃瓧鑺傚簭锛堝ぇ绔級
     int targets = (res[0] & 0xff) | ((res[1] << 8) & 0xff00) // | 鎸変綅鎴�
         | ((res[2] << 24) >>> 8) | (res[3] << 24);
     return targets;
   }

  }
