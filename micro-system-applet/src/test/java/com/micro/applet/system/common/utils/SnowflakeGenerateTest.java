package com.micro.applet.system.common.utils;

import org.junit.Test;

/**
 *  ^  &  操作符计算
 *
 * @author liuhui
 * @version 1.0, 2021/2/1 18:57
 */
public class SnowflakeGenerateTest  {


    @Test
    public void printBinary(){
        System.out.println("BinaryString 1 :  "+Long.toBinaryString(1));
        System.out.println("BinaryString -1 : "+Long.toBinaryString(-1));
        System.out.println("BinaryString      "+Long.toBinaryString(-1L << 12L));
        System.out.println(" 2^31      "+ (2^31));
        System.out.println(" Integer min    "+ Integer.MIN_VALUE);
        System.out.println(" Integer max    "+ Integer.MAX_VALUE);
//        System.out.println("BinaryString -1 : "+Long.toBinaryString(-1));

    }



}