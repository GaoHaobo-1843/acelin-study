package com.gaohb.hello.study.test.commonIOTraning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class IOTest {

    /**
     * 输入：第一行包括一个数据组数t(1 <= t <= 100)
     *      接下来每行包括两个正整数a,b(1 <= a, b <= 10^9)
     * 输出：输出a+b的结果
     **/

    /**
     * 输入：第一行包括一个数据组数t(1 <= t <= 100)
     *      接下来每行包括两个正整数a,b(1 <= a, b <= 10^9)
     * 输出：输出a+b的结果
     **/
    public static void methodB(){
        Scanner scanner = new Scanner(System.in);

        int nums = scanner.nextInt();
        for (int i = 0; i < nums; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a + b);
        }
    }

    /**
     * 输入：第一行包括一个数据组数t(1 <= t <= 100)
     *      接下来每行包括两个正整数a,b(1 <= a, b <= 10^9)
     * 输出：输出a+b的结果
     **/
    public static void methodC(){

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a + b == 0){
                break;
            }
            System.out.println(a + b);
        }
    }

    /**
     * 输入：输入数据包括多组。
     *      每组数据一行,每行的第一个整数为整数的个数n(1 <= n <= 100), n为0的时候结束输入。
     *      接下来n个正整数,即需要求和的每个正整数。
     * 输出：每组数据输出求和的结果
     **/
    public static void methodD(){

        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()){
//            int num = scanner.nextInt();
//            if (num == 0){
//                break;
//            }
//
//            int result = 0;
//            for (int i = 0 ; i < num ; i++){
//                result += scanner.nextInt();
//            }
//            System.out.println(result);
//        }

        while(scanner.hasNext()){
            String[] nums = scanner.nextLine().split(" ");
            if (Integer.parseInt(nums[0]) == 0){
                break;
            }

            int result = 0;
            for (int i = 1 ; i < nums.length ; i++){
                result += Integer.parseInt(nums[i]);
            }
            System.out.println(result);
        }
    }

    /**
     * 输入：输入的第一行包括一个正整数t(1 <= t <= 100), 表示数据组数。
     *      接下来t行, 每行一组数据。
     *      每行的第一个整数为整数的个数n(1 <= n <= 100)。
     *      接下来n个正整数, 即需要求和的每个正整数。
     * 输出：每组数据输出求和的结果
     **/
    public static void methodE() throws IOException {

//        Scanner sc = new Scanner(System.in);
//
//        int t = sc.nextInt();
//        sc.nextLine();
//        for (int j = 0; j < t ; j ++){
//
//            String[] nums = sc.nextLine().split(" ");
//
//            int r = 0;
//            for (int i = 1 ; i < nums.length; i++){
//                r += Integer.parseInt(nums[i]);
//            }
//            System.out.println(r);
//
//        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] temp;
        while((str = br.readLine())!=null){
            temp = str.split(" ");
            int res = 0;
            for(int i=1; i<temp.length; i++){
                res += Integer.parseInt(temp[i]);
            }
            System.out.println(res);
        }

    }

    /**
     * 输入：输入数据有多组, 每行表示一组输入数据。
     *      每行不定有n个整数，空格隔开。(1 <= n <= 100)。
     * 输出：每组数据输出求和的结果
     **/
    public static void methodG() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null){
            String[] arr = line.split(" ");
            int result = 0;
            for (int i = 0 ; i < arr.length ; i ++){
                result += Integer.parseInt(arr[i]);
            }
            if (result == 0) {
                break;
            }

            System.out.println(result);
        }

    }

    /**
     * 输入：输入有两行，第一行n
     *      第二行是n个空格隔开的字符串
     * 输出：输出一行排序后的字符串，空格隔开，无结尾空格
     **/
    public static void methodH() throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        Arrays.sort(str);
        for (int i = 0 ; i < n -1 ;i ++){
            System.out.print(str[i] + " ");
        }
        System.out.print(str[n -1]);

    }

    /**
     * 输入：输入一串字符串，单词用空格分开
     * 输出：最后一个单词的长度
     **/
    public static void printLastWordLength() throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();
//        System.out.println(str.substring(str.lastIndexOf(" ")).length());

        /* 上面用到BufferedReader是为了用到readLine方法，如果只有单行要处理，可以用InputStream */
        InputStream is = System.in;
        char c;
        int i = 0;
        while ( (c = (char)is.read()) != '\n'){ // 换行符占用2个字节
            if (c == ' '){
                i = 0;
            }else {
                i++;
            }
        }
        System.out.println(i);
    }





    public static void main(String[] args){

    }
}
