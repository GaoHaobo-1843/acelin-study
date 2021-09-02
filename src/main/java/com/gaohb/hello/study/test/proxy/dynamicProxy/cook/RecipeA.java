package com.gaohb.hello.study.test.proxy.dynamicProxy.cook;

import java.util.ArrayList;
import java.util.List;

public class RecipeA implements ICooking {

    @Override
    public List<String> preparing() {
        List<String> recipe = new ArrayList<>();
//        System.out.println("处理食材 ====> 开始");
        System.out.println("准备番茄");
        System.out.println("准备鸡蛋");
        recipe.add("鸡蛋");
        recipe.add("番茄");
//        System.out.println("处理食材 ====> 开始");
        return recipe;
    }

    @Override
    public void flavouring(List<String> recipe) {

        System.out.println("放1勺盐");
        System.out.println("我喜欢耗油，还加了一勺耗油");

    }

    @Override
    public int cooking() {
        int min = 10;
        System.out.println("设置了" + min + "分钟");
        return min;
    }


    @Override
    public String serving() {
        System.out.println("准备了个天蓝色圆盘");
        return "天蓝色圆盘";
    }
}
