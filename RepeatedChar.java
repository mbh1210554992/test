package com.ntu;

import java.util.Scanner;

public class RepeatedChar {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str=sc.nextLine();
        boolean flag=isRepeated(str);
        if(flag){
            System.out.println("字符串 "+str+" 存在相同的字符");
        }else{
            System.out.println("字符串 "+str+" 不存在相同的字符");
        }

    }

    /**
     * 将字符串转换为char数组，判断每个字符首次出现于最后出现的位置
     * @param str
     * @return
     */
    static boolean isRepeated(String str){
        boolean flag=false;
        char[] arr=str.toCharArray();
        for(char temp:arr){
            //若字符第一次出现的位置不等于最后一次出现的位置，则表示该字符重复
            if(str.indexOf(temp)!=str.lastIndexOf(temp)){
                flag=true;
            }
        }
        return flag;
    }
}
