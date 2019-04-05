package arithmetic.dp;

/**
 * Author: reiserx
 * Date:2019/2/28
 * Des:动态规划-最短路径
 */
public class MiniDist {

    private int[][] matrix = {{1, 3, 5, 9}, {2, 1, 3, 4}, {5, 2, 6, 7}, {6, 8, 4, 3}};

    /**
     * 解法：使用状态转移表
     *
     * @param n
     * @return
     */
    public int miniDist(int n) {
        int[][] status = new int[n][n];
        int sum = 0;
        //初始化第一行
        for (int i = 0; i < n; i++) {
            sum = sum + matrix[0][i];
            status[0][i] = sum;
        }
        sum = 0;
        //初始化第一列
        for (int i = 0; i < n; i++) {
            sum = sum + matrix[i][0];
            status[i][0] = sum;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                status[i][j] = matrix[i][j] + Math.min(status[i - 1][j], status[i][j - 1]);
            }
        }
        return status[n - 1][n - 1];

    }


    private int[][] mem = new int[4][4];

    /**
     * 解法：使用状态转移方程
     *
     * @param i
     * @param j
     * @return
     */
    public int miniDist2(int i, int j) {
        if (i == 0 && j == 0) {
            return matrix[i][j];
        }

        if (mem[i][j] > 0) {
            return mem[i][j];
        }

        int leftMin = Integer.MAX_VALUE;

        if (j - 1 >= 0) {
            leftMin = miniDist2(i, j - 1);
        }

        int upMin = Integer.MAX_VALUE;

        if (i - 1 >= 0) {
            upMin = miniDist2(i - 1, j);
        }


        int min = matrix[i][j] + Math.min(leftMin, upMin);
        mem[i][j] = min;
        return min;

    }


    public static void main(String[] args) {
        MiniDist miniDist = new MiniDist();

        System.out.println(miniDist.miniDist(4));
        System.out.println(miniDist.miniDist2(3, 3));
    }

}

