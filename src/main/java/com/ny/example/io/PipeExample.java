package com.ny.example.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeExample {
    public static void main(String[] args) throws IOException {
        final PipedOutputStream outputStream = new PipedOutputStream();
        final PipedInputStream inputStream = new PipedInputStream();
        outputStream.connect(inputStream);
        Thread thread1 = new Thread(() -> {
            try {
                outputStream.write("hello world,pipe!".getBytes());
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                int data = inputStream.read();
                while (data!=-1){
                    System.out.println((char)data);
                    data = inputStream.read();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
    }
}
