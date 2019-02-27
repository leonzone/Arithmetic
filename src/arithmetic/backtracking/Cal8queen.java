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



    public static void main(String[] args) {
        Cal8queen queen = new Cal8queen();
        queen.cal8queen(0);

    }


}
