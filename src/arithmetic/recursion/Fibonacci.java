package arithmetic.recursion;

/**
 * @author: reiserx
 * Date:2019/3/28
 * Des:斐波那契数列求值
 */
public class Fibonacci {


    int f(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return f(n - 1) + f(n - 2);
    }


    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        System.out.println(fibonacci.f(5));
    }
}
