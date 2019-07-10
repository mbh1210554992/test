package com.ntu;

public class PrimeNum {
    public static void main( String[] args )
    {
        int count=0;
        System.out.println("101到300之间的素数为：");
        for(int i=101;i<=300;i+=2){   //所有偶数都不是素数，所以用i+2,减少循环次数
            boolean flag=true;
            for(int j=2;j<=Math.sqrt(i);j++){

                if(i%j==0) {
                    flag = false;
                    break;
                }
            }

            if(flag){
                count++;
                System.out.print(i+"  ");
            }

        }
        System.out.println();
        System.out.println("101到300之间一共有"+count+"个素数");
    }
}

