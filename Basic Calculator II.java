Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5


class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int sum=0,num=0;
        char sign='+';
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
            {
                num=num*10 + (c-'0');
            }
            
            if(isOperator(c) || i==s.length()-1)
            {
                if(sign=='+')
                    stack.push(num);
                else if (sign=='-')
                    stack.push(-num);
                else if(sign=='*')
                {
                    int top=stack.pop();
                    stack.push(top * num);
                }
                else if(sign=='/')
                {
                    int top=stack.pop();
                    stack.push(top/ num);
                }
                num=0;
                sign=c;
            }
        }
        while(!stack.isEmpty())
        {
            sum+=stack.pop();
        }
        return sum;
    }
    public boolean isOperator(char c)
    {
        return c=='+' || c=='-' || c=='*' || c=='/';
    }
}
