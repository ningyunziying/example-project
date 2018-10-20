package com.ny.example.io;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

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
        String s = "李";
        System.out.println(s.getBytes().length);
        byte[] bytes = s.getBytes();
        System.out.println(bytes[0]);
    }
}
