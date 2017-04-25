package com;
import java.util.Random;

/**
 * Created by jinzhihang on 2017/4/21.
 * 提供Greate1函数，生成纯数字的四则运算
 * 提供Greate2函数，生成带分数的四则运算
 * 提供Greate3函数，生成带括号的纯数字的四则运算
 */
public class Equation{
    public static StringBuffer Greate1(){
        Random random=new Random();
        char [] Operator={'+','-','×','÷'};
        Integer num1,num2,num3,num4;
        int operator;

        num1=random.nextInt(10)+1;
        num2=random.nextInt(10)+1;
        num3=random.nextInt(10)+1;
        num4=random.nextInt(10)+1;

        operator=random.nextInt(4);
        StringBuffer expression=new StringBuffer(num1.toString()+" "+Operator[operator]+" "+num2.toString());
        operator=random.nextInt(4);
        expression.append(" "+Operator[operator]+" "+num3.toString());
        operator=random.nextInt(4);
        expression.append(" "+Operator[operator]+" "+num4.toString()+'=');

        System.out.print(expression);
        return expression;
    }

    public static StringBuffer Greate2(){
        Random random=new Random();
        char [] Operator={'+','-','×','÷'};
        Integer num1,num2,num3,num4;
        int operator;

        num1 = random.nextInt(10)+1;
        num2 = random.nextInt(10)+1;
        num3 = random.nextInt(10) + 1;
        num4 = random.nextInt(10) + 1;

        while (true){//保证分子小于分母
            if (num3>=num4){
                num3 = random.nextInt(10) + 1;
                num4 = random.nextInt(10) + 1;
            }else {
                break;
            }
        }
        //约分
        int divisor=Gcd(num3,num4);
        num3=num3/divisor;
        num4=num4/divisor;

        operator=random.nextInt(4);
        StringBuffer expression=new StringBuffer(num1.toString()+" "+Operator[operator]+" "+num2.toString());
        operator=random.nextInt(4);
        expression.append(" "+Operator[operator]+" "+num3.toString());
        expression.append('/'+num4.toString()+'=');

        System.out.print(expression);
        return expression;
    }

    public static StringBuffer Greate3(){
        Random random=new Random();
        char [] Operator1={'+','-'};
        char [] Operator2={'×','÷'};
        Integer num1,num2,num3;
        int operator;

        num1 = random.nextInt(10)+1;
        num2 = random.nextInt(10)+1;
        num3 = random.nextInt(10) + 1;

        operator=random.nextInt(2);
        StringBuffer expression=new StringBuffer("("+num1.toString()+" "+Operator1[operator]+" "+num2.toString()+")");
        operator=random.nextInt(2);
        expression.append(" "+Operator2[operator]+" "+num3.toString()+"=");

        System.out.print(expression);
        return expression;
    }

    public static int Gcd(int m,int n) {//求最大公约数
        if (m % n == 0) {
            return n;
        } else {
            return Gcd(n,m % n);
        }
    }

}
