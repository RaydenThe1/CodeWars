import java.util.*;
import java.math.BigInteger;

public class FibDigits {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int fib = sc.nextInt();
        sc.close();
        int[][] result = FibDigits(fib);
        Arrays.stream(result).forEach(c -> System.out.println(c));
        System.out.println();
    }
    public static int[][] FibDigits(int n) {
        List<int[]> list = new ArrayList<>();
        BigInteger fibonacci = calculateFibonacci(n);
        int count;

        // count the occurrences of each number in the fibonacci
        for (int i = 0; i < 10; i++) {
            count = 0; // Reset count for each digit
            for (char value : fibonacci.toString().toCharArray()) {
                if (Integer.valueOf(Character.toString(value)) == i) {
                    count++;
                }
            }

            // store the number and its occurrences
            if (count > 0) {
                list.add(new int[]{count, i});
            }
        }


        // sort the array with respect to the number of occurrences of each digit in descending order
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return Integer.compare(o2[0], o1[0]);
                } else {
                    return Integer.compare(o2[1], o1[1]);
                }
            }
        });        System.out.println();
        list.stream().forEach(c -> System.out.println("{" + c[0] + ", " + c[1] + "}"));

        // convert List<int[]> to int[][]
        int[][] array = list.toArray(new int[0][]);
        return array;
    }

    private static BigInteger calculateFibonacci(int n) {
        if (n == 0 || n == 1) {
            return BigInteger.valueOf(n);
        }

        BigInteger[] fib = new BigInteger[n + 1];
        fib[0] = BigInteger.ZERO;
        fib[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }

        return fib[n];
    }
}