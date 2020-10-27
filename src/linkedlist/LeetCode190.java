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

    /**
     * 通过不断交换来实现类似于颠倒的操作
     * @param n
     * @return
     */
    public int reverseBits2(int n) {
        n = ((n & 0xffff0000) >>> 16) | ((n & 0x0000ffff) << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }
}
