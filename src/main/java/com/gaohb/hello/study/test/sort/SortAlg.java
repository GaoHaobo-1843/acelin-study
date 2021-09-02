package com.gaohb.hello.study.test.sort;

public class SortAlg {

    /**
     * 【冒泡排序】
     * 最简单的最暴力的排序方法，二维循环
     * @param numbers 待排序数组
     **/
     public static int[] bubbleSort(int[] numbers){

         int length = numbers.length;
         for (int i = 0; i < length; i++){
             for (int j = i + 1; j < length; j++){
                 if (numbers[i] > numbers[j]){
                     int tmp = numbers[i];
                     numbers[i] = numbers[j];
                     numbers[j] = tmp;
                 }
             }
         }
         return numbers;
     }

     /**
      * 快速排序
      * 采用分治的思路，通常把第一个数拿出来保存，然后计算出该值的正确位置，然后以该位置为切割点吧数组切成两段数组，分别递归处理
      * 原数组要作为递归函数的入参，以便对每个分段进行位置调整
      * 所以可以定义两个游标来记录处理数组的首末位置，而当首末位置重合时，递归结束
      **/
     public static void quickSort(int[] numbers, int begin, int end){

         if (begin < end){
             int index = getCorrectIndexAndAdjust(numbers,begin,end);
             quickSort(numbers,begin,index - 1) ;
             quickSort(numbers,index + 1,end) ;
         }
     }

     /**
      * 计算正确位置并调整
      **/
     private static int getCorrectIndexAndAdjust(int[] arr, int begin,int end ){

         int tmp = arr[begin];
         while(begin < end){
             while (begin < end && arr[end] > tmp){
                 end --;
             }
             arr[begin] = arr[end];
             while(begin < end && arr[begin] < tmp){
                 begin ++;
             }
             arr[end] = arr[begin];
         }
         arr[begin] = tmp;
         return end;

     }


     public static void main(String[] args){

         /* 初始化一个无序数组 */
         int[] numbers = {41,52,6,13,24,65,42,36,8,14,66,22,39,17,89,45,28};

         /* 冒泡排序 */
         long bobbleBegin = System.currentTimeMillis();
         printArray(bubbleSort(numbers));
         long bobbleEnd = System.currentTimeMillis();
         System.out.println("冒泡排序 ===> 耗时：" + (bobbleEnd - bobbleBegin) + "ms");

         /* 快速排序 */
         long quickBegin = System.currentTimeMillis();
         quickSort(numbers,0,numbers.length - 1);
         printArray(numbers);
         long quickEnd = System.currentTimeMillis();
         System.out.println("快速排序 ===> 耗时：" + (quickEnd - quickBegin ) + "ms");
     }

     public static void printArray(int[] array){

         for (int i =0; i < array.length; i++){
             System.out.print(array[i] + " ");
         }

     }
}
