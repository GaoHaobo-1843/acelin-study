package com.gaohb.hello.study.test.machineTest;

import java.util.ArrayList;
import java.util.Collections;

public class HWTest {
    public static void main(String[] args){


        ArrayList<String> employeeIdList =  new ArrayList<>();
        employeeIdList.add("ss789");
        employeeIdList.add("12n00");
        employeeIdList.add("s00123");
        employeeIdList.add("k2 3490");
        employeeIdList.add("S123");
        employeeIdList.add("x235");
        employeeIdList.add("m990");

        System.out.println(processEmployeeIds(employeeIdList));
    }

    public static ArrayList<String> processEmployeeIds (ArrayList<String> employeeIdList) {

        ArrayList<String> result = new ArrayList<>();
        for (String str: employeeIdList
             ) {
            if (check(str)){

                String s = str.replace(" ","").trim();
                int n = 9 - s.length();

                String sr = Character.toLowerCase(s.charAt(0)) + getZeros(n) + s.substring(1);
                if(!result.contains(sr)){
                    result.add(sr);
                }

            }
        }
        Collections.sort(result);

        return result;
    }


    public static String getZeros(int n){
        StringBuilder str = new StringBuilder();
        for (int i = 0 ; i < n ; i ++ ){
            str.append("0");
        }
        return str.toString();
    }



    public static boolean check(String str){
        String s = str.replace(" ","").trim();
        int l = s.length();
        if (l > 9){
            return false;
        }
        for (int i = 0 ; i < l ; i ++ ){
            char c = s.charAt(i);
            if (i == 0){
                if (!Character.isLetter(c)){
                    return false;
                }
            }else {
                if (!Character.isDigit(c)){
                    return false;
                }
            }

        }
        return true;

    }



    public static String mergeAlternately (String word1, String word2) {

        int l1 = word1.length();
        int l2 = word2.length();
        int l = Math.min(l1, l2);
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < l; i ++){
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }
        if (l1 > l2){
            result.append(word1.substring(l));
        }else {
            result.append(word2.substring(l));
        }

        return result.toString();

    }


    public static boolean isSumOfPowerThree (int n) {
        if ((n % 3) == 0 ){
            return isSumOfPowerThree (n / 3);
        }else if((n - 1) % 3 == 0 && (n != 1)){
            return isSumOfPowerThree ((n - 1) / 3);
        }else if(n == 1){
            return true;
        }else{
            return false;
        }
    }
}
