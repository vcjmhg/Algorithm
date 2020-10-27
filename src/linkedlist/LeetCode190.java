package linkedlist;

public class LeetCode190 {
    /**
     * 基本思路：
     * 每次都获取最后一位的数值，然后左移到对应位置
     * 这是最常规的思路
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int power = 31;
        int result = 0;
        // don't use "n != 0" to judge because the bit count of n can be not 32
        for (int i = 0; power >= 0; i++) {
            result += (n & 1) << power;
            n = n >> 1;
            power--;
        }
        return result;
    }
}
