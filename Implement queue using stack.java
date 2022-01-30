 Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

Implement the MyQueue class:

void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.

Example 1:

Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]

Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
class MyQueue {
    int front,rear,size=0;
    int[] s=new int[100];

    public MyQueue() {
        front=-1;
        rear=-1;
    }
    
    public void push(int x) {
        if(front==-1)
        {
            front=0;
            rear=0;
        }
        s[rear]=x;
        size++;
        rear++;
    }
    
    public int pop() {
        int x=s[front];
        front++;
        size--;
        return x;
    }
    
    public int peek() {
        int x=s[front];
        return x;
    }
    
    public boolean empty() {
        if(size<=0)
            return true;
        else
            return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
