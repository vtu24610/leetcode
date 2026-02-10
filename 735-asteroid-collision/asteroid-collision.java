import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int a : asteroids) {
            boolean alive = true;

            while (alive && !stack.isEmpty() && stack.peek() > 0 && a < 0) {
                int top = stack.peek();

                if (Math.abs(top) < Math.abs(a)) {
                    stack.pop();
                } else if (Math.abs(top) == Math.abs(a)) {
                    stack.pop();
                    alive = false;
                } else {
                    alive = false;
                }
            }

            if (alive) {
                stack.push(a);
            }
        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
