import java.util.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0; // pointer for popped array

        for (int val : pushed) {
            stack.push(val); // push current value

            // pop from stack while top matches popped[j]
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        // if stack is empty, the sequence is valid
        return stack.isEmpty();
    }
}
