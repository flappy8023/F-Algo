package base.btree;

/**
 * @Auther: luweiming
 * @Date: 2023/11/10 21:33
 * @Description:
 */
public class Test {
    int a = getA();

    public int getA() {
        System.out.println("invoke ");
        return 11;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(2090));
        System.out.println(2090 & (~((0x1) << 11)));
        System.out.println(Integer.toBinaryString(2090 & (~((0x1) << 11))));
        System.out.println(setBit(2090, 0, 0) + "    " + Integer.toBinaryString(setBit(2090, 0, 0)));
        System.out.println(setBit(2090, 11, 1) + "     " + Integer.toBinaryString(setBit(2090, 11, 1)));
        for (int i = 0; i < 12; i++) {
            System.out.println(getBit(2090, i));
        }
    }

    public static int setBit(int num, int pos, int value) {
        int length = Integer.toBinaryString(num).length();

        if (value == 0) {
            return num & (~(0x1 << (length - pos - 1)));
        } else {
            return num | (0x1 << (length - pos - 1));
        }
    }

    public static int getBit(int num, int pos) {
        int length = Integer.toBinaryString(num).length();
        return (num >> (length - 1 - pos)) & 1;
    }

}
