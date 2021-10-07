ls// fib(n) = fib(n-1) + fib(n-2)

import java.util.*;
class Fibonacci {
  public static void main(String[] args) {
    System.out.println(fib_recurse(8));
    System.out.println(memoize(6));
    System.out.println(tabulate(6));
  }

  // O(2^n) and O(n)
  public static int fib_recurse(int n){
      if(n <= 1) return n;
    return fib_recurse(n-1)+fib_recurse(n-2);
  }

  // O(n) O(n)
  public static int memoize(int n){
    Map<Integer, Integer> memo = new HashMap<>();
    memo.put(1,1);
    memo.put(2,1);

    return memo_util(n, memo);
  }

  public static int memo_util(int n, Map<Integer, Integer> memo){
    if(memo.containsKey(n)) return memo.get(n);

    memo.put(n, memo_util(n-1, memo)+memo_util(n-2, memo));
    return memo.get(n);

  }

  // O(n) O(n)
  public static int tabulate(int n){
    int[] tab = new int[n+1];
    Arrays.fill(tab, 0);
    tab[1] = 1;

    for(int i=0; i<n; i++){
      tab[i+1] += tab[i];
      if(i+2 < n+1)
        tab[i+2] += tab[i];
    }

    return tab[n];
  }


}