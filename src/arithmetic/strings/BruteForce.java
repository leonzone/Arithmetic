package arithmetic.strings;

/**
 * Author: reiserx
 * Date:2019/1/14
 * Des:find substring use BruteForce
 */
public class BruteForce {
    public int indexOf(String main, String pattern) {

        char[] mainchars = main.toCharArray();
        char[] pchars = pattern.toCharArray();

        for (int i = 0; i < mainchars.length - pchars.length; i++) {
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
        System.out.println(bf.indexOf("aabcdef", "abc"));
    }
}
