package arithmetic.recursion;

/**
 * @author: reiserx
 * Date:2019/3/28
 * Des:阶乘
 */
public class Factorial {
    public int f(int n) {
        if (n == 1) {
            return 1;
        }
        return f(n - 1) * n;
    }

    public static void main(String[] args) {
        Factorial factorial=new Factorial();
        System.out.println(factorial.f(5));
    }
}
