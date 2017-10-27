// Count the number of prime numbers less than a non-negative number, n.

public class CountPrimes {

    // iterative
    public static int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = i * 2; j < n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }
}
