package com.ntu;

import java.util.Scanner;

/**
 * 5个数排序
 * 方法： 将输入的整数存到数组中，再利用冒泡排序进行排序
 *
 */
public class NumSort
{
    public static void main( String[] args )
    {
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[5];
        System.out.println("请输入5个整数：");
        for(int i=0;i<5;i++){
            arr[i]=sc.nextInt();
        }

        sort(arr);

        for(int temp:arr){
            System.out.print(temp+" ");
        }
    }

    /**
     * 冒泡排序
     * @param arr
     */
    public static void sort(int[] arr){

            for(int i=0;i<arr.length;i++){
            //添加一个标记（增强性能），如果此次循环没有发生交换，说明排序已经完成，则直接跳出循环
            boolean flag=true;
            for(int j=0;j<arr.length-i-1;j++){ //此处要注意数组越绝问题
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    //顺序发生变化时，将标志位改成false
                    flag=false;
                }
            }

            if(flag){
                break;
            }
        }
    }
}
