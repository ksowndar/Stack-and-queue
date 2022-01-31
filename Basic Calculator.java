Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
  
  
  
  class Solution {
    public int calculate(String s) {
        int sum=0,sign=1;
        Stack<Integer> stack=new Stack();
        
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>='0' && s.charAt(i)<='9')
            {
                int num=0;
                while(i<s.length() && s.charAt(i)>='0' && s.charAt(i)<='9')
                {
                    num=num*10+s.charAt(i)-'0';
                    i++;
                }
                sum=sum + (num*(sign));
                i--;
            }
            else if(s.charAt(i)=='+')
                sign=1;
            else if(s.charAt(i)=='-')
                sign=-1;
            else if(s.charAt(i)=='(')
            {
                stack.push(sum);
                stack.push(sign);
                sign=1;
                sum=0;
            }
            else if(s.charAt(i)==')')
            {
                sum=stack.pop()*sum;
                sum+=stack.pop();
            }
        }
        return sum;
    }
}
