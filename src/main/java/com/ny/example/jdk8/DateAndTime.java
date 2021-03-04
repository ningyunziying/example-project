package com.ny.example.jdk8;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateAndTime {

    //Java 8中有一个叫LocalDate的类，它能用来表示今天的日期。
    // 这个类与java.util.Date略有不同，因为它只包含日期，没有时间。
    // 因此，如果你只需要表示日期而不包含时间，就可以使用它。
    @Test
    public void ex01() {
        LocalDate today = LocalDate.now();
        System.out.println("Today's Local date : " + today);
        //Today's Local date : 2019-04-01
    }

    //获取当前的年月日
    @Test
    public void ex02() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        System.out.println(today.getMonth());
        System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);
        //APRIL
        //Year : 2019 Month : 4 day : 1
    }

    //工厂方法LocalDate.of()，则可以创建出任意一个日期，它接受年月日的参数，然后返回一个等价的LocalDate实例。
    @Test
    public void ex03() {
        LocalDate date = LocalDate.of(2019, 4, 3);
        System.out.println(date);
    }

    //LocalDate重写了equals方法来进行日期的比较
    @Test
    public void ex04() {
        LocalDate today = LocalDate.now();
        LocalDate date1 = LocalDate.of(2014, 01, 14);
        if (date1.equals(today)) {
            System.out.printf("Today %s and date1 %s are same date %n", today, date1);
        } else {
            System.out.printf("Today %s and date1 %s are not same date %n", today, date1);
        }

        //Today 2019-04-02 and date1 2014-01-14 are not same date
    }

    // 如何在Java 8中获取当前时间
    @Test
    public void ex5() {
        LocalDateTime time = LocalDateTime.now();
        System.out.println("local time now : " + time);
        Clock clock = Clock.systemUTC();
        System.out.println(clock.getZone());
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        System.out.println(time.format(formatter));
    }
}
