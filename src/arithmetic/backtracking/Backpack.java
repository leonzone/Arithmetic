package arithmetic.backtracking;

/**
 * Author: reiserx
 * Date:2019/2/27
 * Des:回溯算法 0-1背包
 */
public class Backpack {

    /**
     * 存储背包中物品总重量的最大值
     */
    public int maxW = -1;

    /**
     * @param i     第几个物品
     * @param cw    现在背包的重量
     * @param items 物品
     * @param n     总个数
     * @param w     最大重量
     */
    public void f(int i, int cw, int[] items, int n, int w) {
        if (i == n || cw == w) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        //1.不放入背包
        f(i + 1, cw, items, n, w);
        //2.放入背包
        if (items[i] + cw <= w) {
            f(i + 1, items[i] + cw, items, n, w);
        }

    }


    public static void main(String[] args) {
        Backpack backpack = new Backpack();
        int[] a = {55, 2, 3, 4, 5, 6, 7, 8, 9, 1};
        backpack.f(0, 0, a, 10, 100);
        System.out.println(backpack.maxW);
    }
}
