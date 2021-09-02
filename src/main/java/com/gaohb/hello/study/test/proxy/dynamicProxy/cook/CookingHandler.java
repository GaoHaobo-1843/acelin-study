package com.gaohb.hello.study.test.proxy.dynamicProxy.cook;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class CookingHandler implements InvocationHandler {

    private Object object;

    public CookingHandler(Object object){this.object = object;}

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String methodName = method.getName();
        switch (methodName){

            case "preparing":{
                System.out.println("------------------ 准备食材 ==> 开始");
                List<String> recipe = (List<String>) method.invoke(object,args);
                for (String food: recipe
                     ) {
                    System.out.println("清洗食材：" + food);
                }
                System.out.println("将食材切好备好装盘");
                System.out.println("------------------ 准备食材 ==> 结束");
                return recipe;
            }
            case "flavouring":{
                System.out.println("------------------ 调味 ==> 开始");
                method.invoke(object,args);
                System.out.println("------------------ 调味 ==> 结束");
                return null;
            }
            case "cooking":{
                int cookTime = (int) method.invoke(object,args);
                System.out.println("烹饪" + cookTime + "分钟");
                System.out.println("------------------ 烹饪 ==> 开始");
                Thread.sleep(cookTime * 1000);
                System.out.println("------------------ 烹饪 ==> 结束");
                Method serving = proxy.getClass().getMethod("serving");
                serving.invoke(proxy,null);
                return cookTime;
            }
            case "serving":{
                System.out.println("------------------ 装盘上菜 ==> 开始");
                String str = (String) method.invoke(object,args);
                System.out.println("将食物装到" + str + "里，出菜！");

                System.out.println("------------------ 装盘上菜 ==> 结束");
                return str;
            }
            default:{
                return method.invoke(object,args);
            }
        }
    }
}
