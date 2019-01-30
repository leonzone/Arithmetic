package arithmetic.strings;

/**
 * Author: reiserx
 * Date:2019/1/14
 * Des:find substring use BruteForce
 */
public class BruteForce {
    public int indexOf(String haystack, String needle) {


        char[] mainchars = haystack.toCharArray();
        char[] pchars = needle.toCharArray();

        if (pchars.length == 0 || haystack.equals(needle)) {
            return 0;
        }
        for (int i = 0; i <= mainchars.length - pchars.length; i++) {
            if (mainchars[i] == pchars[0]) {
                if (pchars.length == 1) {
                    return i;
                } else {
                    for (int j = 1; j < pchars.length; j++) {
                        if (mainchars[i + j] != pchars[j]) {
                            break;
                        } else {
                            if (j == pchars.length - 1) {
                                return i;
                            }
                        }
                    }
                }
            }

        }

        return -1;
    }


    public static void main(String[] args) {
        BruteForce bf = new BruteForce();
//        System.out.println(bf.indexOf("aabcdef", "abc"));
//        System.out.println(bf.indexOf("", ""));
//        System.out.println(bf.indexOf("a", ""));
//        System.out.println(bf.indexOf("", "a"));
//        System.out.println(bf.indexOf("a", "a"));
//        System.out.println(bf.indexOf("ccccccab", "abc"));
        System.out.println(bf.indexOf("mississippi", "pi"));
    }
}
