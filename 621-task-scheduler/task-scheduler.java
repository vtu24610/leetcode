import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) freq[t - 'A']++;

        Arrays.sort(freq);
        int maxFreq = freq[25];
        int numMaxFreqTasks = 0;

        // count how many tasks have the maximum frequency
        for (int f : freq) {
            if (f == maxFreq) numMaxFreqTasks++;
        }

        // formula: max(tasks.length, (maxFreq - 1) * (n + 1) + numMaxFreqTasks)
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + numMaxFreqTasks);
    }
}