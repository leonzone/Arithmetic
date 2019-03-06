package structure;

/**
 * Author: reiserx
 * Date:2019/3/6
 * Des:位图，布隆筛选
 */

public class Bitmap { // Java 中 char 类型占 16bit，也即是 2 个字节
    private char[] bytes;
    private int nbits;

    public Bitmap(int nbits) {
        this.nbits = nbits;
        this.bytes = new char[nbits / 16 + 1];
    }

    public void set(int k) {
        if (k > nbits) {
            return;
        }
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        bytes[byteIndex] |= (1 << bitIndex);
    }

    public boolean get(int k) {
        if (k > nbits) {
            return false;
        }
        int byteIndex = k / 16;
        int bitIndex = k % 16;
        return (bytes[byteIndex] & (1 << bitIndex)) != 0;
    }

    public static void main(String[] args) {
//        BitSet
        Bitmap bitmap=new Bitmap(32);

        bitmap.set(2);
        System.out.println(bitmap.get(2));
        System.out.println(bitmap.get(3));
    }
}

