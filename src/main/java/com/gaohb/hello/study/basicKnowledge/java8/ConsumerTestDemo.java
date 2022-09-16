package com.gaohb.hello.study.basicKnowledge.java8;

import java.util.function.Consumer;

/**
 *
 */
public class ConsumerTestDemo {


    public static void main(String[] args) {
        //定义一个数组
        String[] strArray = {"周杰伦,30", "魏无羡,25", "蓝忘机,25"};
        //调用方法，用Lambda作为参数传递（用split方法分割字符串获取想要的部分并输出）
        getIno(strArray, (String s) -> {
            String name = s.split(",")[0];
            System.out.print("姓名：" + name);
        }, (String s) -> {
            int age = Integer.parseInt(s.split(",")[1]);
            System.out.println(",年龄:" + age);
        });
        //可简化为
//        getIno(strArray,s-> System.out.print("姓名："+s.split(",")[0]),
//                s-> System.out.println(",年龄："+Integer.parseInt(s.split(",")[1])));
    }
    //定义一个方法
    private static void getIno(String[] strArray, Consumer<String> con1, Consumer<String> con2) {
        //遍历数组得到每一个字符串
        for (String s : strArray) {
            //将两个Consumer接口按照顺序组合到一起使用
            con1.andThen(con2).accept(s);
        }
    }

}
