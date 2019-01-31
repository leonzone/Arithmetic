package arithmetic.strings;

/**
 * Author: reiserx
 * Date:2019/1/31
 * Des: KMP
 */
public class KMP {

    // a, b 分别是主串和模式串；n, m 分别是主串和模式串的长度。
    public int kmp(char[] a, int n, char[] b, int m) {
        int[] next = getNexts(b, m);
        int j = 0;
        for (int i = 0; i < n; ++i) {
            while (j > 0 && a[i] != b[j]) { // 一直找到 a[i] 和 b[j]
                j = next[j - 1] + 1;
            }
            if (a[i] == b[j]) {
                ++j;
            }
            if (j == m) { // 找到匹配模式串的了
                return i - m + 1;
            }
        }
        return -1;
    }

    // b 表示模式串，m 表示模式串的长度
    private int[] getNexts(char[] b, int m) {
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; ++i) {
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }


    public int indexOf(String haystack, String needle) {
        if (needle.length() == 0 || haystack.equals(needle)) {
            return 0;
        }
        return kmp(haystack.toCharArray(), haystack.length(), needle.toCharArray(), needle.length());
    }


    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println(kmp.indexOf("aabcdef", "abc"));
        System.out.println(kmp.indexOf("", ""));
        System.out.println(kmp.indexOf("a", ""));
        System.out.println(kmp.indexOf("", "a"));
        System.out.println(kmp.indexOf("ccccccab", "abc"));
        System.out.println(kmp.indexOf("mississippi", "pi"));
    }
}
