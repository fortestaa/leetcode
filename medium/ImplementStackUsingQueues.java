package medium;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
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
    
	public static void main(String[] args) {
		ImplementStackUsingQueues t = new ImplementStackUsingQueues();
		t.push(1);
		//System.out.println(t.empty());
		t.pop();
		
		t.push(1);
		t.push(2);
		System.out.println(t.top());
		System.out.println(t.top());
	}
}
