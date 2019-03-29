package arithmetic.array;

/**
 * @author reiserx
 * Date:2019/3/27
 * Des:
 */
public class MergeTwoArray {

    public int[] mergeTwoArray(int[] a, int[] b) {

        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[a.length + b.length];

        while (true) {
            if (i == a.length) {
                for (int l = j; l < b.length; l++) {
                    result[k] = b[l];
                    k++;
                }

                break;

            }
            if (j == b.length) {
                for (int l = i; l < a.length; l++) {
                    result[k] = a[l];
                    k++;
                }
                break;
            }

            if (a[i] < b[j]) {
                result[k] = a[i];
                i++;
            } else {
                result[k] = b[j];
                j++;
            }
            k++;

        }
        return result;

    }


    public static void main(String[] args) {
        MergeTwoArray mergeTwoArray = new MergeTwoArray();
        int[] a = new int[]{1, 3, 5, 7};
        int[] b = new int[]{2, 4, 6, 8};

        int[] result = mergeTwoArray.mergeTwoArray(a, b);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
