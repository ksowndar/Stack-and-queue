
class Solution {
    char[] arr;
    int index=0;
    public int calculate(String s) {
        arr=s.toCharArray();
        return dfs();
    }
    
    private int dfs()
    {
        Stack <Integer> stack = new Stack();
        char sign='+';
        while(index<arr.length)
        {
            if(arr[index]!=' ')
            {
                if(Character.isDigit(arr[index]))
                {
                    StringBuilder num=new StringBuilder();
                    while(index<arr.length && Character.isDigit(arr[index]))
                    {
                        num.append(arr[index++]);
                    }
                    index--;
                    int n=Integer.parseInt(num.toString());
                    insertElement(stack,n,sign);
                }
                else if(arr[index]=='(')
                {
                    index++;
                    int n=dfs();
                    insertElement(stack,n,sign);
                }
                else if(arr[index]==')')
                    break;
                else
                    sign=arr[index];
            }
            index++;
        }
        int sum=0;
        while(!stack.isEmpty())
        {
            sum+=stack.pop();
        }
        return sum;
    }
    public void insertElement(Stack<Integer> stack,int num,int operator)
    {
        if(operator=='-')
            num=num*-1;
        else if(operator=='*')
        {
            num=num*stack.pop();
        }
        else if(operator=='/')
        {
            num=num/stack.pop();
        }
        stack.push(num);
    }
}
