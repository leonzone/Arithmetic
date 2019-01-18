package arithmetic.sorts;

/**
 * Created by reiserx on 2018/10/25.
 */
public class Sorts {

    // 冒泡排序
    public void bubbleSort(int[] a) {
        int n = a.length;
        if (n <= 1) return;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

    //插入排序
    public void insertSort(int[] a) {
        int n = a.length;
        if (n < 1) return;
        for (int i = 1; i < n; i++) {
            int j = i;
            int value = a[j];
            for (; j > 0; j--) {
                if (value < a[j - 1]) {
                    a[j] = a[j - 1];
                } else {
                    break;
                }
            }
            a[j]=value;
        }


    }

    public void selectionSort(int[] a){

    }
}
