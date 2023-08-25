package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class _225ImplementStackusingQueues {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
//        myStack.push(2);
//        myStack.push(3);

        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
        System.out.println(myStack.empty());


    }

    //pick/add elements only from top
    static class MyStack {

        // add only to back, add to top
        private Queue queue1;
        int top;
        //private final Queue queue2 = new LinkedList();

        public MyStack() {
            queue1 = new LinkedList();
            top = 0;
        }

        public void push(int x) {
            // 1 2 3
            queue1.offer(x);
            top = x;
        }

        // 1 2 3 4
        // 2 3 4 1
        // 3 4 1 2
        // 4 3 2 1

        public int pop() {
            int size = queue1.size() - 2;
            if (size < 0) {
                top = 0;
                return queue1.isEmpty() ? 0 : (int) queue1.poll();
            }
            while (size != 0) {
                queue1.offer(queue1.poll());
                size--;
            }
            top = (int) queue1.peek();
            queue1.offer(queue1.poll());
            return (int) queue1.poll();
        }

        public int top() {
            return top;
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }
}
