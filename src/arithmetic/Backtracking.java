package arithmetic;

/**
 * Author: reiserx
 * Date:2019/1/25
 * Des:回溯思想
 */
public class Backtracking {

    private int maxW = Integer.MIN_VALUE; // 结果放到 maxW 中
    private int[] weight = {2, 2, 4, 6, 3};  // 物品重量
    private int n = 5; // 物品个数
    private int w = 6; // 背包承受的最大重量
    private boolean[][] mem = new boolean[5][10]; // 备忘录，默认值 false


    public void f1(int i, int cw) { // 调用 f(0, 0)
        if (cw == w || i == n) {
            if (cw > maxW) maxW = cw;
            System.out.println(maxW);
            return;
        }
        f1(i + 1, cw);
        if (cw + weight[i] <= w) {
            f1(i + 1, cw + weight[i]);
        }

    }


    public void f2(int i, int cw) { // 调用 f(0, 0)
        if (cw == w || i == n) { // cw==w 表示装满了，i==n 表示物品都考察完了
            if (cw > maxW) maxW = cw;
            System.out.println(maxW);
            return;
        }
        if (mem[i][cw]) return; // 重复状态
        mem[i][cw] = true; // 记录 (i, cw) 这个状态
        f2(i + 1, cw); // 选择不装第 i 个物品
        if (cw + weight[i] <= w) {
            f2(i + 1, cw + weight[i]); // 选择装第 i 个物品
        }
    }



    public static void main(String[] args) {
        Backtracking backtracking = new Backtracking();
        backtracking.f1(0, 0);
        System.out.println("--------------------");
        backtracking.f2(0, 0);
    }

}
