/**
 * Copyright(C) 2016,2026,LHF,Inc
 */
package learnJNAandJNI;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * @author LouHF
 *
 */

public interface JNATest extends Library {
    JNATest INSTANCE = (JNATest) Native.loadLibrary(
                "D:/CC/Tools_Tool_ITT_StdPrj_Dev/PF_Tools_VOB/Tools_SubTool/src/JNATest/Release/JNATest", JNATest.class);
    public void set(int i);
    public int get();

}

