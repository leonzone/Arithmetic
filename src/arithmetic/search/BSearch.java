package arithmetic.search;

/**
 * @author: reiserx
 * Date:2019/3/29
 * Des:二分查找法
 */
public class BSearch {

    public int search(int[] a, int value) {
        int low = 0;
        int height = a.length - 1;

        while (low <= height) {
            int middle = low + ((height - low) >> 1);
            if (a[middle] == value) {
                return middle;
                //目标在左半部分
            } else if (a[middle] > value) {
                height = middle - 1;
                //目标在右半部分
            } else {
                low = middle + 1;
            }
        }

        return 0;
    }


    public int searchFirst(int[] a, int value) {
        int low = 0;
        int height = a.length - 1;

        while (low <= height) {
            int middle = low + ((height - low) >> 1);
            if (a[middle] == value) {

                if (middle == 0 || a[middle - 1] != value) {
                    return middle;
                }
                height = middle - 1;
                //目标在左半部分
            } else if (a[middle] > value) {
                height = middle - 1;
                //目标在右半部分
            } else {
                low = middle + 1;
            }
        }

        return 0;
    }


    public int searchLast(int[] a, int value) {
        int low = 0;
        int height = a.length - 1;

        while (low <= height) {
            int middle = low + ((height - low) >> 1);
            if (a[middle] == value) {
                if (middle == a.length - 1 || a[middle + 1] != value) {
                    return middle;
                }
                low = middle + 1;
                //目标在左半部分
            } else if (a[middle] > value) {
                height = middle - 1;
                //目标在右半部分
            } else {
                low = middle + 1;
            }
        }
        return 0;
    }


    public int searchFirstBQ(int[] a, int value) {
        int low = 0;
        int height = a.length - 1;

        while (low <= height) {
            int middle = low + ((height - low) >> 1);
            //目标在左半部分
            if (a[middle] >= value) {
                if ((middle == 0) || (a[middle - 1] < value)) {
                    return middle;
                } else {
                    height = middle - 1;
                }
                //目标在右半部分
            } else {
                low = middle + 1;
            }
        }

        return 0;
    }

    public int searchLastSQ(int[] a, int value) {
        int low = 0;
        int height = a.length - 1;

        while (low <= height) {
            int middle = low + ((height - low) >> 1);
            //目标在左半部分
            if (a[middle] <= value) {
                if ((middle == a.length - 1) || (a[middle + 1] > value)) {
                    return middle;
                } else {
                    low = middle + 1;
                }
                //目标在右半部分
            } else {

                height = middle - 1;
            }
        }

        return 0;
    }


    public static void main(String[] args) {
        BSearch bSearch = new BSearch();

        System.out.println(bSearch.search(new int[]{2, 4, 5, 7, 8, 9}, 4));
        System.out.println(bSearch.searchFirst(new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18}, 8));
        System.out.println(bSearch.searchLast(new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18}, 8));
        System.out.println(bSearch.searchFirstBQ(new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18}, 8));
        System.out.println(bSearch.searchLastSQ(new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18}, 8));
    }
}
