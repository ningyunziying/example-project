package com.ny.example.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.concurrent.locks.ReentrantLock;

public class StreamExample {
    @Test
    public void ByteArrayTest() throws Exception {
        byte[] bytes = new byte[1024];
        //write data into byte array...
        InputStream input = new ByteArrayInputStream(bytes);
        //read first byte
        int data = input.read();
        while (data != -1) {
            //do something with data
            //read next byte
            data = input.read();
        }

    }
    @Test
    public void byteTest(){
        byte d = '3';
        String s = new String("宁");
        System.out.println(s.getBytes().length);
        s.toCharArray();
        byte[] bytes = s.getBytes(Charset.forName("utf-8"));
        byte[] bytes2 = s.getBytes(Charset.forName("iso-8859-1"));
        byte[] bytes3 = s.getBytes(Charset.forName("GBK"));
        byte a[] ="国庆60周年".getBytes();
        char[] b="国庆60周年".toCharArray();
        System.out.println(bytes[0]);
        String ss = "宁";
        System.out.println(s.length());

    }
}
