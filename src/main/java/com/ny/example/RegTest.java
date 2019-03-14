package com.ny.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegTest {
    public static void main(String[] args) {
        String a = "<a href=\"1\">1</a><a href=\"2\">2</a>";
        //
        Pattern p1 = Pattern.compile("<a(.+?)>(.+?)</a>");
        Matcher m1 = p1.matcher(a);
        while (m1.find()){
            System.out.println(m1.group());
            System.out.println(m1.group(1));
            System.out.println(m1.group(2));
        }
    }
}
