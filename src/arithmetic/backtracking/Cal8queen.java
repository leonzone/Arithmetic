package arithmetic.backtracking;

/**
 * Author: reiserx
 * Date:2019/2/27
 * Des:回溯思想-八皇后问题
 */
public class Cal8queen {

    int[] result = new int[8];

    public void cal8queen(int row) {//求解的行
        if (row == 8) {
            printQueens(result);
            return;
        }
        for (int column = 0; column < 8; ++column) {
            if (isOk(row, column)) {
                result[row] = column;
                cal8queen(row + 1);
            }
        }


    }

    private boolean isOk(int row, int column) {
        int leftup = column - 1;
        int rightup = column + 1;

        for (int i = row - 1; i >= 0; --i) {
            if (result[i] == column) {
                return false;
            }
            if (leftup >= 0) {
                if (result[i] == leftup) {
                    return false;
                }
            }
            if (rightup < 8) {
                if (result[i] == rightup) {
                    return false;
                }
            }
            --leftup;
            ++rightup;
        }

        return true;
    }


    private void printQueens(int[] result) { // 打印出一个二维矩阵
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public int maxW = Integer.MIN_VALUE; // 存储背包中物品总重量的最大值

    // cw 表示当前已经装进去的物品的重量和；i 表示考察到哪个物品了；
// w 背包重量；items 表示每个物品的重量；n 表示物品个数
// 假设背包可承受重量 100，物品个数 10，物品重量存储在数组 a 中，那可以这样调用函数：
// f(0, 0, a, 10, 100)
    public void f(int i, int cw, int[] items, int n, int w) {
        if (cw == w || i == n) { // cw==w 表示装满了 ;i==n 表示已经考察完所有的物品
            System.out.println(maxW);
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        //1.放入书包
        f(i + 1, cw, items, n, w);
        //2.不放入书包
        if (cw + items[i] <= w) {// 已经超过可以背包承受的重量的时候，就不要再装了
            f(i + 1, cw + items[i], items, n, w);
        }
    }


    public static void main(String[] args) {
        Cal8queen queen = new Cal8queen();

//        queen.cal8queen(0);
        int[] a = {55, 2, 3, 4, 5, 6, 7, 8, 9, 1};
        queen.f(0, 0, a, 10, 100);
        System.out.println(queen.maxW);

    }


}
