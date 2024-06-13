package first;

public class BitOperators {

    public static void main(String[] args) {
        BitOperators sample = new BitOperators();
        sample.andOrXorSample();
    }

    private void printValue(String variableName, int a) {
        System.out.println(variableName + "=");
        int aZeroCount = Integer.numberOfLeadingZeros(a);

        for (int loop = 0; loop < aZeroCount; loop++) {
            System.out.print("0");
        }

        if (Integer.SIZE == aZeroCount) {
            System.out.println("\t[" + a + "]");
        } else {
            System.out.println(Integer.toBinaryString(a) + "\t[" + a + "]");
        }
    }

    private void andOrXorSample() {
        int a = -10, b = 10;
        andOperation(a, b);
        orOperation(a, b);
        xorOperation(a, b);
    }

    private void andOperation(int a, int b) {
        int result = a & b;
        System.out.println("Bitwise AND");
        printValue("a", a);
        printValue("b", b);
        printValue("a&b", result);
        System.out.println();
    }

    private void orOperation(int a, int b) {
        int result = a | b;
        System.out.println("Bitwise OR");
        printValue("    a", a);
        printValue("    b", b);
        printValue("    a|b", result);
        System.out.println();
    }

    private void xorOperation(int a, int b) {
        int result = a ^ b;
        System.out.println("Bitwise XOR");
        printValue("        a", a);
        printValue("        b", b);
        printValue("        a^b", result);
        System.out.println();
    }
}
