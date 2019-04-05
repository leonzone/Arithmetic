package arithmetic.dp;

/**
 * Author: reiserx
 * Date:2019/1/25
 * Des: 动态规划
 */
public class Dynamic {

    /**
     * 0-1背包问题
     *
     * @param weight 物品重量
     * @param n      物品个数
     * @param w      背包可承载重量
     * @return
     */
    private int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1]; // 默认值 false
        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        states[0][weight[0]] = true;
        for (int i = 1; i < n; ++i) { // 动态规划状态转移
            for (int j = 0; j <= w; ++j) {// 不把第 i 个物品放入背包
                if (states[i - 1][j]) {
                    states[i][j] = states[i - 1][j];
                }
            }
            for (int j = 0; j <= w - weight[i]; ++j) {// 把第 i 个物品放入背包
                if (states[i - 1][j]) {
                    states[i][j + weight[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[n - 1][i]) {
                return i;
            }
        }
        return 0;
    }


    private int knapsack2(int[] items, int n, int w) {
        boolean[] states = new boolean[w + 1]; // 默认值 false
        states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        states[items[0]] = true;
        for (int i = 1; i < n; ++i) { // 动态规划
            for (int j = w - items[i]; j >= 0; --j) {// 把第 i 个物品放入背包
                if (states[j] == true) states[j + items[i]] = true;
            }
        }
        for (int i = w; i >= 0; --i) { // 输出结果
            if (states[i] == true) return i;
        }
        return 0;
    }


    // items 商品价格，n 商品个数, w 表示满减条件，比如 200
    private void double11advance(int[] items, int n, int w) {
        boolean[][] states = new boolean[n][3 * w + 1];// 超过 3 倍就没有薅羊毛的价值了
        states[0][0] = true;  // 第一行的数据要特殊处理
        states[0][items[0]] = true;
        for (int i = 1; i < n; ++i) { // 动态规划
            for (int j = 0; j <= 3 * w; ++j) {// 不购买第 i 个商品
                if (states[i - 1][j] == true) states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= 3 * w - items[i]; ++j) {// 购买第 i 个商品
                if (states[i - 1][j] == true) states[i][j + items[i]] = true;
            }
        }

        int j;
        for (j = w; j < 3 * w + 1; ++j) {
            if (states[n - 1][j] == true) break; // 输出结果大于等于 w 的最小值
        }
        if (j == -1) return; // 没有可行解
        for (int i = n - 1; i >= 1; --i) { // i 表示二维数组中的行，j 表示列
            if (j - items[i] >= 0 && states[i - 1][j - items[i]] == true) {
                System.out.print(items[i] + " "); // 购买这个商品
                j = j - items[i];
            } // else 没有购买这个商品，j 不变。
        }
        if (j != 0) System.out.print(items[0]);
    }


    public static void main(String[] args) {
        Dynamic dynamic = new Dynamic();

        System.out.println(dynamic.knapsack(new int[]{2, 2, 4, 6, 3}, 5, 9));
        System.out.println(dynamic.knapsack2(new int[]{2, 2, 4, 6, 3}, 5, 9));
        dynamic.double11advance(new int[]{59, 89, 79, 259, 199}, 5, 200);
    }

}
