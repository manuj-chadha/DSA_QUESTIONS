class Solution {
    public int binaryGap(int n) {
        int last = -1, maxGap = 0, index = 0;

        while (n > 0) {
            if ((n & 1) == 1) {  // Check if the rightmost bit is 1
                if (last != -1) {
                    maxGap = Math.max(maxGap, index - last);
                }
                last = index;  // Update last seen 1's position
            }
            n >>= 1;  // Right shift n to process the next bit
            index++;
        }

        return maxGap;
    }
}