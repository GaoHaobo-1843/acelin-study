package com.gaohb.hello.study.basicKnowledge.extend;

/**
 * @author H
 * 2022/9/24 11:24
 */
public class Lion extends LandCreature {

    public Lion() {
        System.out.println("狮子王诞生！");
    }

    public Lion(String foot, String header, String body) {
        super(foot, header, body);
        System.out.println("狮子王诞生！头部：【" + header + "】身体：【" + header + " 】脚：【" + foot + "】 ");
    }

    public static void main(String[] args) {
        Lion lion = new Lion();
        System.out.println("---------------------------");
        Lion Lion = new Lion("强壮的大腿", "带着鬃毛的头" , "威武的身体");
    }
}
