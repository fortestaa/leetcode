package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225	Implement Stack using Queues
 * https://leetcode.com/problems/implement-stack-using-queues/
 * 
 * Implement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class Implement_Stack_using_Queues {
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
	
    // Push element x onto stack.
    public void push(int x) {
        q1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
    	if (empty())	return;
    	
        while (q1.size() != 1) {
        	q2.offer(q1.poll());
        }
        q1.poll();
        while (q2.size() > 0) {
        	q1.offer(q2.poll());
        }
    }

    // Get the top element.
    public int top() {
    	if (empty())	return Integer.MAX_VALUE;
    	
    	while (q1.size() != 1) {
        	q2.offer(q1.poll());
        }
        int i = q1.peek();
        q2.offer(q1.poll());
        
        while (q2.size() > 0) {
        	q1.offer(q2.poll());
        }
        return i;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}