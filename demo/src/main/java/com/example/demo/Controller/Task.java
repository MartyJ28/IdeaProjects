package com.example.demo.Controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.math.*;

/**
 * 定时任务的使用
 * @author
 **/
@Component
public class Task {
    @Scheduled(cron = "20 2/7 * * * ?")   //每5秒执行一次
    public void execute1() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置日期格式
        System.out.println(df.format(new Date()));
    }
    @Scheduled(cron = "40 4/7 * * * ?")   //每5秒执行一次
    public void execute2() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置日期格式
        System.out.println(df.format(new Date()));
    }
    @Scheduled(cron = "0 7/7 * * * ?")   //每5秒执行一次
    public void execute3() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置日期格式
        System.out.println(df.format(new Date()));
    }

    public static void main(String[] args) {
        List<String> test1 = test(250);
        int count = test1.size();
        for(int i = 0;i < count;i++){
           System.out.println(test1.get(i));
        }
        long a = 23L, b = 24L;
        long c = a/b;
        System.out.println(test1.toString());
    }

    public static List<String> test(int freq){
        List<String> res = new ArrayList<>();
        String cron = "";
        //java找最小公倍数的函数
        if(freq < 60){
            cron = freq +" * * * * ?";
        }
        int gcd = gcd(freq,60);//   140
        int lcm = freq * 60 / gcd;//
        int count = lcm / freq;
        int last =lcm / 60;
        int accumulate = 0, before = 0;
        for(int i = 1;i <= count;i++){
            before += (accumulate + freq) / 60;
            accumulate = (accumulate + freq) % 60;
            cron = "0 " + accumulate + " " + before + "/" + last + " * * ?";
            res.add(cron);
            System.out.println(cron);
        }
        return res;
    }

    public static  int gcd(int x,int y){
        if(x < y){
            int temp = x;
            x = y;
            y = temp;
        }
        int rem = -1;
        while( x % y != 0){
            rem = x % y;
            x = y;
            y = rem;
        }
        return y;
    }
}
