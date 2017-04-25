package com;
import java.util.Stack;

/**
 * Created by jinzhihang on 2017/4/21.
 * 该类提供Suffix中缀转后缀的函数
 * 和根据后缀计算答案的Calculate函数
 */
public class Core {

    public static StringBuffer Suffix(StringBuffer infix){
        Stack<Character> stack=new Stack <Character>();
        StringBuffer suffix=new StringBuffer();
        int i=0;
        char tempchar=infix.charAt(i++);
        char tempchar2=' ';
        try {
            while (tempchar!='='){
                switch (tempchar){
                    case '(':
                        stack.push(tempchar);
                        tempchar=infix.charAt(i++);
                        break;
                    case ')':
                        while (stack.peek()!='('){
                            tempchar2=stack.pop();
                            suffix.append(tempchar2);
                            suffix.append(' ');
                            if (stack.empty()) {
                                break;
                            }
                        }
                        if (!stack.empty()) {
                            stack.pop();
                        }
                        tempchar=infix.charAt(i++);
                        break;
                    case '+':
                    case '-':
                        while (!stack.empty()&&stack.peek()!='('){
                            tempchar2=stack.pop();
                            suffix.append(tempchar2);
                            suffix.append(' ');
                        }
                        stack.push(tempchar);
                        tempchar=infix.charAt(i++);
                        break;
                    case '×':
                    case '*':
                    case '/':
                    case '÷':
                        Character ch=new Character(' ');
                        if (!stack.empty()) {
                            while((ch=stack.peek()).equals('×')||(ch=stack.peek()).equals('÷'))
                            {
                                tempchar2=stack.pop();
                                suffix.append(tempchar2);
                                suffix.append(' ');
                                if (stack.empty()) {
                                    break;
                                }
                            }
                        }
                        stack.push(tempchar);
                        tempchar=infix.charAt(i++);
                        break;
                    case ' ':
                        tempchar=infix.charAt(i++);
                        break;
                    default:
                        while(tempchar<='9'&&tempchar>='0')
                        {
                            suffix.append(tempchar);
                            tempchar=infix.charAt(i++);
                        }
                        suffix.append(' ');
                        break;
                }


            }
            while(!stack.empty())
            {
                tempchar2=stack.pop();
                suffix.append(tempchar2);
                suffix.append(' ');
            }

            suffix.append('\0');
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suffix;
    }

    //根据后缀表达式计算结果（小数格式的String类型）
    public static String Calculate(StringBuffer suffix){
        int i=0;
        char tempchar=suffix.charAt(i++);
        double []answer=new double[20];
        int top=0,d;
        String Answer= null;
        try {
            while (tempchar!='\0'){
                switch (tempchar){
                    case '+':
                        answer[top-1]=answer[top-1]+answer[top];
                        top--;
                        tempchar=suffix.charAt(i++);
                        break;
                    case '-':
                        answer[top-1]=answer[top-1]-answer[top];
                        top--;
                        tempchar=suffix.charAt(i++);
                        break;
                    case '*':
                    case '×':
                        answer[top-1]=answer[top-1]*answer[top];
                        top--;
                        tempchar=suffix.charAt(i++);
                        break;
                    case '/':
                    case '÷':
                        try {
                            if(answer[top]!=0)
                                answer[top-1]=answer[top-1]/answer[top];
                            else
                            {
                                System.out.println("\n\t除零错误!\n");
                                throw new InvalidExpression("无效的表达式");
                            }
                        } catch (InvalidExpression invalidExpression) {
                            invalidExpression.printStackTrace();
                            System.exit(0);
                        }
                        top--;
                        tempchar=suffix.charAt(i++);
                        break;
                    case ' ':
                        tempchar=suffix.charAt(i++);
                        break;
                    default:
                        d=0;
                        while(tempchar>='0'&&tempchar<='9')
                        {
                            d=10*d+tempchar-'0';//将数字字符转化为对应的数值
                            tempchar=suffix.charAt(i++);
                        }
                        top++;
                        answer[top]=d;
                        break;
                }
            }
            Answer = null;
            if (top!=1){
                throw new InvalidExpression("无效的表达式");
            }
            Double an=new Double(answer[top]);
            Answer = new String(an.toString());

        }catch (InvalidExpression invalidExpression) {
            invalidExpression.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return Answer;
    }

}
