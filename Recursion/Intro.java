class Intro {

    static int LogBase2(int n) {
        if (n == 1) // for cahnging it into Log3 N, change condition to, n < 3
            return 0;
        else
            return 1 + LogBase2(n / 2); // change /2 to /3
    }

    static void intToBinary(int n) {
        if (n == 0)
            return;
        intToBinary(n / 2);
        System.out.print(n % 2 + " ");
    }

    static void fun(int n) {
        if (n == 0)
            return;

        fun(n - 1);

        System.out.println(n);

        fun(n - 1);
    }

    static void fun1(int n) {
        if (n == 0) // base case for termination
            return;

        System.out.println("GFG");

        fun1(n - 1);
    }

    static void fun1() { // stackoverflow will occur
        System.out.println("GFG");
        fun1();
    }

    static void nToOne(int n) {
        if (n <= 0) // this is tail recursive, i.e. the last statement in the block is recursive
                    // call, so the modern compiler is going to replace, that with a goto to the
                    // start. No extra overhead, of saving in function call stack.
            return;
        System.out.print(n + " ");
        nToOne(n - 1);
    }

    static void oneToN(int n) { // O(n) | auxSpaceO(n)
        // non tail recursive, as it has a statement after recursive call
        // it can be converted to, tail recursive using another parameter, which is
        // passed along with n
        if (n <= 0)
            return;
        oneToN(n - 1);
        System.out.print(n + " ");
    }

    static int fact(int n) {
        // #1 non tail recusive
        if (n == 0)
            return 1;
        return n * fact(n - 1); // non tail recursive, as we need to multiply by n
    }

    static int factTailRec(int n, int k) {
        // #2
        if (n == 0)
            return k;
        return factTailRec(n - 1, k * n); // tail recusive
    }

    static int fibonacci(int n) { // O(2^n) exponential growth
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int sumOfNaturalNumber(int n) { // O(n) | auxSpace O(n)
        if (n == 0) // base case
            return 0;
        return n + sumOfNaturalNumber(n - 1); // non tail recursive
    }

    static boolean PalindromeCheckRec(String a, int s, int e) { // O(n) | auxSpace O(n)
        if (s >= e)
            return true;
        return (a.charAt(s) == a.charAt(e)) && PalindromeCheckRec(a, s + 1, e - 1);
    }

    static int SumOfDigits(int n) { // O(d) | auxSpace O(d), d - digit in a num
        if (n == 0) // use n <= 9, return n, for saving one recursive call
            return 0;
        else
            return n % 10 + SumOfDigits(n / 10);
    }

    static int getSum(int n) { // O(d) | auxSpace O(1)
        int res = 0;
        while (n > 0) {
            res = res + n % 10;
            n = n / 10;
        }
        return res;
    }

    static int ropeCutting(int n, int a, int b, int c) { // O(3^n)
        if (n < 0)
            return -1;
        if (n == 0)
            return 0;
        int max = Math.max(ropeCutting(n - a, a, b, c),
                Math.max(ropeCutting(n - b, a, b, c), ropeCutting(n - c, a, b, c)));
        if (max == -1)
            return -1;
        return max + 1;
    }

    static void subset(String a, String cur, int index) {
        if (index == a.length()) {
            System.out.print(cur + " ");
            return;
        }
        subset(a, cur, index + 1);
        subset(a, cur + a.charAt(index), index + 1);
    }

    // here A is C is destination and A is starting point, b being the auxillary.
    // first we recursively call for getting 1st disk to be placed, then we, place
    // n-1 disk, from A to B, while C acting as auxSpace, then we print moving of
    // nth disk from A to C, then we again call for, moving disk from B to C using A
    // as an auxSpace
    static void TOH(int n, char A, char B, char C) {
        if (n == 1) {
            System.out.println("Move 1 from " + A + " to " + C);
            return;
        }
        TOH(n - 1, A, C, B);
        System.out.println("Move " + n + " from " + A + " to " + C);
        TOH(n - 1, B, A, C);
    }

    static int josephus(int n, int k) { // O(n)
        if (n == 1)
            return 0;

        return (josephus(n - 1, k) + k) % n;
    }

    // #1
    static int subsetSumProblem(int a[], int sum, int level, int cur) { // O(2^n)
        if (level == a.length) {
            if (cur == sum) {
                return 1;
            }
            return 0;
        }
        return subsetSumProblem(a, sum, level + 1, cur) + subsetSumProblem(a, sum, level + 1, cur + a[level]);
    }

    // #2
    static int subsetSumProblem2(int a[], int sum, int n) { // O(2^n)
        if (n == a.length) {
            return (sum == 0) ? 1 : 0;
        }
        return subsetSumProblem2(a, sum, n + 1) + subsetSumProblem2(a, sum - a[n], n + 1);
    }

    static String swap(String s, int start, int end) {
        if (s == "")
            return s;
        char[] c = s.toCharArray();
        char temp = c[start];
        c[start] = c[end];
        c[end] = temp;
        return new String(c);

    }

    static void printPermutationsOfString(String s, int index) { // for n = lenght of dtring it has n! permu
        if (index == s.length() - 1) {
            System.out.println(s + " ");
            return;
        }
        for (int i = index; i < s.length(); i++) {
            s = swap(s, index, i);
            printPermutationsOfString(s, index + 1);
            s = swap(s, index, i);
        }
    }

    public static void main(String[] args) {
        // fun1(3);
        // fun(3);
        System.out.println(LogBase2(16)); // if n>=1, it returns Log2 N | for non multiple of 2 it gives, floor of
                                          // Log2 N, i.e. it will give same ans for fun(16) to fun(31)
        intToBinary(10); // for n > 0
        System.out.println();
        nToOne(5);
        System.out.println();
        oneToN(5);
        System.out.println("\n" + fact(5) + "\n" + factTailRec(5, 1)); // we need to pass k as 1
        System.out.println();

        System.out.println(fibonacci(6));
        System.out.println();

        System.out.println(sumOfNaturalNumber(10));
        System.out.println();

        System.out.println(PalindromeCheckRec("aba", 0, 2) + " \n");

        System.out.println(SumOfDigits(2320));
        System.out.println(getSum(2320) + "\n");

        System.out.println(ropeCutting(5, 1, 5, 10) + "\n");

        subset("ABC", "", 0); // for string n, there are going to be 2^n subsets, or subsequence which is
                              // removing 0 or more character from the string while keeping the order same

        System.out.println("\n");
        TOH(3, 'A', 'B', 'C');
        System.out.println();

        System.out.println(josephus(5, 3)); // standing from, 0 to N-1
        System.out.println();

        int[] a = { 10, 20, 15 };
        System.out.println(subsetSumProblem(a, 25, 0, 0));
        System.out.println(subsetSumProblem2(a, 25, 0));
        System.out.println();

        printPermutationsOfString("ABC", 0);

    }
}
