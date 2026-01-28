import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }

    public int[] plusOne(int[] digits) {

        int[] incremented = new int[digits.length + 1];
        boolean incrementNext = true;

        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i] + (incrementNext ? 1 : 0);
            if (digit == 10) {
                incremented[i + 1] = 0;
                incrementNext = true;
            } else {
                incremented[i + 1] = digit;
                incrementNext = false;
            }
        }

        if (incrementNext) {
            incremented[0] = 1;
            return incremented;
        } else {
            return Arrays.copyOfRange(incremented, 1, incremented.length);
        }
    }
}