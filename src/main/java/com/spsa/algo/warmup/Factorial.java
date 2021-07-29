package com.spsa.algo.warmup;

import org.junit.Assert;

public class Factorial {
                                                 // 0 1 2 3 4 5 6
    public static int factorialBottomUp(int n) { // 1 1 2 3 5 8 13
        int a = 1;
        int b = 1;
        for (int i = 2; i <= n; i++) { 
            int temp = b;
            b = a + b;
            a = temp;
            System.out.println(a + "," + b);
        }
        return b;
    }
    public static void main(String[] args) {
        Assert.assertEquals(5, factorialBottomUp(4));
        Assert.assertEquals(8, factorialBottomUp(5));
        Assert.assertEquals(13, factorialBottomUp(6));
    }
}

// 0 1 2 3 4 5
// 1 1 2 3 5 8

// a b i 
// 1 1 2 3 5 8

//   a b i 
// 1 1 2 3 5 8

//     a b i 
// 1 1 2 3 5 8