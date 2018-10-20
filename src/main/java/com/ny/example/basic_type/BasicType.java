package com.ny.example.basic_type;

import java.util.concurrent.Future;

public class BasicType {
    public static void main(String[] args) {
        //基本数据类型
        /**
         * boolean -> Boolean
         * char -> Character
         */
        /**
         * • For byte,  from -128                   to 127,             inclusive
         * • For short, from -32768                 to 32767,           inclusive
         * • For int,   from -2147483648            to 2147483647,      inclusive
         * • For long,  from -9223372036854775808   to 9223372036854775807, inclusive
         * • For char,  from '\u0000'               to '\uffff' inclusive, that is, from 0 to 65535
         */
        System.out.println("------------------------------boolean----------------------------");
        boolean b = Boolean.FALSE;
        char a = 'a';
        System.out.println(a);
        System.out.println("------------------------------char----------------------------");

        System.out.println(Character.MIN_VALUE);
        System.out.println(Character.MAX_VALUE);
        System.out.println("------------------------------byte----------------------------");
        byte b1 = 12;
        Byte b2 = 12;
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
        System.out.println("------------------------------short----------------------------");
        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);
        System.out.println("------------------------------int----------------------------");
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println("------------------------------long----------------------------");
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        System.out.println("------------------------------float----------------------------");
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
        System.out.println("------------------------------double----------------------------");
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
    }
}
