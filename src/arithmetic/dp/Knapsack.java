package arithmetic.dp;

/**
 * Author: reiserx
 * Date:2019/2/28
 * Des:动态规划-01背包
 */
public class Knapsack {

    /**
     * @param weight 物品重量
     * @param n      物品个数
     * @param w      背包可承载重量
     * @return
     */
    public int knapsack(int[] weight, int n, int w) {
        // 默认值 false
        boolean[] states = new boolean[w + 1];
        //第0行哨兵处理
        states[0] = true;
        if (weight[0] < w) {
            states[weight[0]] = true;
        }
        for (int i = 1; i < n; i++) {
            //放入背包
            //j 需要从大到小来处理。如果我们按照 j 从小到大处理的话，会出现 for 循环重复计算的问题。
            for (int j = w - weight[i]; j >= 0; j--) {
                if (states[j]) {
                    states[j + weight[i]] = true;
                }
            }
        }
        //输出结果
        for (int i = w; i >= 0; --i) {
            if (states[i]) {
                return i;
            }
        }

        return 0;
    }

    /**
     * 物品有价值的 01 背吧问题
     * @param weight 物品重量
     * @param value 物品价值
     * @param n 物品总数
     * @param w 背包总承受
     * @return
     */
    public  int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w + 1];
        // 初始化 states
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < w + 1; ++j) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        // 动态规划，状态转移
        states[0][weight[0]] = value[0];
        // 不选择第 i 个物品
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= w; ++j) {
                if (states[i - 1][j] >= 0) {
                    states[i][j] = states[i - 1][j];
                }
            }
            // 选择第 i 个物品
            for (int j = 0; j <= w - weight[i]; ++j) {
                if (states[i - 1][j] >= 0) {
                    int v = states[i - 1][j] + value[i];
                    if (v > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = v;
                    }
                }
            }
        }
        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n - 1][j] > maxvalue) {
                maxvalue = states[n - 1][j];
            }
        }
        return maxvalue;
    }


    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();
        int[] a = {55, 2, 3, 4, 5, 6, 7, 8, 9, 1};
        int[] b1 = {55, 2, 3, 4, 5, 6, 7, 8, 9, 1};
        int[] b2 = {55, 2, 3, 4, 5, 6, 7, 8, 9, 1};
        System.out.println(knapsack.knapsack(a, 10, 100));
        System.out.println(knapsack.knapsack3(b1,b2, 10, 100));
    }

}
