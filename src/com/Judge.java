package com;

import java.util.Scanner;

/**
 * Created by jinzhihang on 2017/4/21.
 * 该类提供判断用户输入是否正确的函数
 */
public class Judge extends Main{
    //正则表达式优化用户输入的判断，并输出正确答案（错误时输出）
    public static boolean  Judgement(String answer){
        Scanner input=new Scanner(System.in);
        String UserAnswer=input.next();//接收用户输入

        while(true){
            if(UserAnswer.indexOf("quit")!=-1){//程序退出输入
                System.out.println("程序退出");
                System.out.println("正确题数："+Tnumber);
                System.out.println("错误题数："+Fnumber);
                if (Fnumber+Tnumber==0){
                    System.out.println("正确率为0%");
                }else {
                    Double accuracy=(double)Tnumber/(Tnumber+Fnumber)*100;
                    System.out.println("正确率为"+accuracy+"%");
                }
                System.out.println("感谢您的使用！");
                System.exit(0);

            }else if(UserAnswer.matches("\\-?[0-9]+/[0-9]+")){//用户输入分数形式
                int sign=UserAnswer.indexOf('/');
                String StringNumerator=UserAnswer.substring(0,sign);
                String StringDenominator=UserAnswer.substring(sign+1);
                Integer integerNumerator=Integer.parseInt(StringNumerator);
                Integer integerDenominator=Integer.parseInt(StringDenominator);
                if(integerDenominator==0){
                    System.out.println("分母不能为零，请再次输入");
                    UserAnswer=input.next();
                }else {
                    Double an=new Double((double)integerNumerator/integerDenominator);
                    String DisposeUserAnswer=new String(an.toString());
                    if (DisposeUserAnswer.equals(answer)) {
                        System.out.println("true");
                        return true;
                    }else {
                        System.out.print("false ");
                        System.out.println("正确答案是："+answer);
                        return false;
                    }
                }

            }else if(UserAnswer.matches("\\-?[0-9]+\\.[0-9]+")) {//含有小数点的输入
                if (answer.equals(UserAnswer)) {
                    System.out.println("true");
                    return true;
                } else {
                    System.out.print("false ");
                    System.out.println("正确答案是：" + answer);
                    return false;
                }

            }else if(UserAnswer.matches("\\-?[0-9]+")){//整数输入
                int sign=answer.indexOf('.');
                String StringInteger =answer.substring(0,sign);
                Integer integer=Integer.parseInt(StringInteger);
                Integer integerUserAnswer=Integer.parseInt(UserAnswer);
                if(integer.equals(integerUserAnswer)){
                    System.out.println("true");
                    return true;
                }else{
                    System.out.print("false ");
                    System.out.println("正确答案是："+answer);
                    return false;
                }

            }else{//非法的输入
                System.out.println("非法输入，请再次输入");
                UserAnswer=input.next();
            }
        }
    }

}
