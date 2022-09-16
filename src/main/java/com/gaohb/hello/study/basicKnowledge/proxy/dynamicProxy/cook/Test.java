package com.gaohb.hello.study.basicKnowledge.proxy.dynamicProxy.cook;

import java.lang.reflect.Proxy;
import java.util.List;

public class Test {

    public static void main(String[] args){

        RecipeA recipeA = new RecipeA();
        CookingHandler cookingHandler = new CookingHandler(recipeA);
        ICooking cooking = (ICooking) Proxy.newProxyInstance(recipeA.getClass().getClassLoader(), recipeA.getClass().getInterfaces(),cookingHandler );

        List<String> recipe =  cooking.preparing();
        cooking.flavouring(recipe);
        cooking.cooking();
    }
}
