package com;

import java.util.Random;
import java.util.Scanner;

import static com.Core.Calculate;
import static com.Judge.Judgement;

/**
 * Created by jinzhihang on 2017/4/21.
 * 提供统计题数函数的类
 */
public class Statistics extends Main{

    public static void Stats(){//统计题数的函数
        Scanner input=new Scanner(System.in);
        System.out.print("请输入您想要做的题数，按quit可退出：");
        String StringQnumber=input.next();
        while (true){
            if (StringQnumber.equals("quit")){
                System.out.println("感谢您的使用！");
                System.exit(0);
            }else if(StringQnumber.matches(".*[0-9]+.*")){
                Integer Qnumber=Integer.parseInt(StringQnumber);
                while (Qnumber>0){
                    StringBuffer suffix=new StringBuffer();
                    Random random=new Random();
                    int num=random.nextInt(3);//随机产生题型
                    switch (num){
                        case 0:
                            suffix=Core.Suffix(Equation.Greate1());
                            break;
                        case 1:
                            suffix=Core.Suffix(Equation.Greate2());
                            break;
                        case 2:
                            suffix=Core.Suffix(Equation.Greate3());
                            break;
                    }
                    String answer=Calculate(suffix);
                    if (Judgement(answer)){
                        Tnumber++;
                    }else {
                        Fnumber++;
                    }
                    Qnumber--;
                }
                break;
            }else {
                System.out.print("您输入的是什么意思，我看不懂，请再次输入：");
                StringQnumber=input.next();
            }
        }


        System.out.println("正确题数："+Tnumber);
        System.out.println("错误题数："+Fnumber);
        if (Fnumber+Tnumber==0){
            System.out.println("正确率为0%");
        }else {
            Double accuracy=(double)Tnumber/(Tnumber+Fnumber)*100;
            System.out.println("正确率为"+accuracy+"%");
        }

    }
}
