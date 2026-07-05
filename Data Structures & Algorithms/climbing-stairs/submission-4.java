class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        
        int n_1 = 1;
        int n_2 = 2;
        int n_3 = 0;

        while (n > 2) { 
            n_3 = n_2 + n_1;
            n_1 = n_2;
            n_2 = n_3;
            n--;
        }
        return n_3;
    }
}
/*
n = 1 -> 1

n = 2 -> 2

n = 3 -> 3
1 + 1 + 1
2 + 1
1 + 2

n = 4 -> 5

1 + 1 + 1 + 1
2 + 2
1 + 2 + 1
1 + 1 + 2
2 + 1 + 1

pattern is fibonnacci




base:
fib(0) = 0
fib(1) = 1
fib(n) = fib(n-1) + fib(n-2)

fib(5) = fib(4) + fib(3)

fib(4) = fib(3) + fib(2) => 3

fib(3) = fib(2) + fib(1) => 2

fib(2) = fib(1) + fib(0) => 1

*/
