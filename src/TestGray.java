
/**
 * @author Robert Guetzkow, Maximilian Mackeprang
 *         based on program by Wolf Mueller
 *
 * test class for your implementation of the Gray codes
 * Your class Gray has to be in the same directory or
 * in the CLASSPATH
 * good luck :-)
 */
public class TestGray {

    static int points = 0;

    /**
     * Gives the bit representation on an Integer.
     *
     * @param i the integer to be converted
     * @return String of bits
     */
    public static String bits(int i) {
        String s = String.format("%32s", Integer.toBinaryString(i));
        return s.replace(' ', '0');
    }

    public static void feedback(int nr, String check, Boolean status, String details) {
        System.out.format("%4s %1d  %5s %-60s [%5b]%n", "Test", nr, "Case:", check, status);
        System.out.println("========================================================");
        System.out.println(details);
        System.out.println("");
    }


    public static void test1() {
        String details = "";
        boolean ok = false;
        int result = Gray.toGray(0);

        if (result == 0) {
            points += 1;
            ok = true;
        }

        details = String.format("%-8s: %32s%n%-8s: %32s%n", "Expected", bits(0), "Result", bits(result));
        feedback(1, "Gray.toGray(0)==0", ok, details);
    }

    public static void test2() {
        String details = "";
        boolean ok = false;
        int result = Gray.toGray(Integer.MAX_VALUE);

        if (result == 1073741824) {
            points += 1;
            ok = true;
        }

        details = String.format("%-8s: %32s%n%-8s: %32s%n", "Expected", bits(1073741824), "Result", bits(result));
        feedback(2, "Gray.toGray(" + Integer.MAX_VALUE + ")==1073741824", ok, details);
    }

    public static void test3() {
        String details = "";
        boolean ok = false;

        // choose a random sample point
        int n = (int) (Math.random() * (Integer.MAX_VALUE - 1));
        int part1 = Gray.toGray(n);
        int part2 = Gray.toGray(n + 1);
        int xor = part1 ^ part2;
        // Hamming distance = 1?
        details += String.format("%-8s: %32s%n", "n", bits(part1));
        details += String.format("%-8s: %32s%n", "n+1", bits(part2));
        details += String.format("%-8s: %32s%n", "xor", bits(xor));
        int distance = Integer.bitCount(xor);

        if (distance == 1) {
            points += 3;
            ok = true;
        }

        details += String.format("%-25s: %-32s%n%-25s: %-32s%n", "Expected Hamming Distance", 1, "Result   Hamming Distance", distance);
        feedback(3, "Gray.toGray(" + n + ")^Gray.toGray(" + (n + 1) + ")", ok, details);
    }

    public static void test4() {
        String details = "";
        boolean ok = false;
        int n = Integer.MAX_VALUE - 1;
        int part1 = Gray.toGray(n);
        int part2 = Gray.toGray(n + 1);
        int xor = part1 ^ part2;
        // Hamming distance = 1?
        details += String.format("%-8s: %32s%n", "n", bits(part1));
        details += String.format("%-8s: %32s%n", "n+1", bits(part2));
        details += String.format("%-8s: %32s%n", "xor", bits(xor));
        int distance = Integer.bitCount(xor);

        if (distance == 1) {
            points += 1;
            ok = true;
        }

        details += String.format("%-25s: %-32s%n%-25s: %-32s%n", "Expected Hamming Distance", 1, "Result   Hamming Distance", distance);
        feedback(4, "Gray.toGray(" + n + ")^Gray.toGray(" + (n + 1) + ")", ok, details);
    }

    public static void test5() {
        String details = "";
        boolean ok = false;
        int result = Gray.fromGray(0);

        if (result == 0) {
            points += 1;
            ok = true;
        }

        details = String.format("%-8s: %32s%n%-8s: %32s%n", "Expected", bits(0), "Result", bits(result));
        feedback(5, "Gray.fromGray(" + 0 + ")==0", ok, details);
    }

    public static void test6() {
        String details = "";
        boolean ok = false;
        int result = Gray.fromGray(Integer.MAX_VALUE);

        if (result == 1431655765) {
            points += 1;
            ok = true;
        }

        details = String.format("%-8s: %32s%n%-8s: %32s%n", "Expected", bits(1431655765), "Result", bits(result));
        feedback(6, "Gray.fromGray(" + Integer.MAX_VALUE + ")==1431655765", ok, details);
    }

    public static void test7() {
        String details = "";

        boolean ok = false;
        int result = 0;
        int n = 0;


        // choose a random sample point
        n = (int) (Math.random() * (Integer.MAX_VALUE - 1));
        result = Gray.fromGray(Gray.toGray(n));

        if (result == n) {
            points += 1;
            ok = true;
        }

        details = String.format("%-8s: %32s%n%-8s: %32s%n", "Expected", bits(n), "Result", bits(result));
        feedback(7, "Gray.fromGray(Gray.toGray(" + n + "))", ok, details);
    }

    public static void test8() {
        String details = "";
        boolean ok = false;
        int result = Gray.fromGray(Gray.toGray(Integer.MAX_VALUE));
        if (result == Integer.MAX_VALUE) {
            points += 1;
            ok = true;
        }

        details = String.format("%-8s: %32s%n%-8s: %32s%n", "Expected", bits(Integer.MAX_VALUE), "Result", bits(result));
        feedback(8, "Gray.fromGray(Gray.toGray(" + Integer.MAX_VALUE + "))", ok, details);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        //Tests with toGray
        test1();
        test2();
        test3();
        test4();
        //Tests with fromGray
        test5();
        test6();
        //Test with fromGray(toGray(n))
        test7();
        test8();
        System.out.println("=============================");
        System.out.println("Estimated Result: " + points + "/10 points!");
        System.out.println("=============================");
    }

}