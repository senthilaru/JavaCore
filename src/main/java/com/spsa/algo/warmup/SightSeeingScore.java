package com.spsa.algo.warmup;

import org.junit.Assert;

public class SightSeeingScore {

    public int quadraticBruteForceWay(int[] values) {
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                int score = values[i] + values[j] - (j - i);
                if (score > max) {
                    max = score;
                }
                System.out.printf("[%s,%s] - [%s,%s] = Score: %s", i, j, values[i], values[j], score);
                System.out.println();
            }
        }
        return max;
    }

    public int linearWay(int[] values) {
        int max = 0;
        int anchor =0;
        for (int end = 1; end < values.length; end++) {
            int score = values[anchor] + values[end] - (end - anchor);
            if (score > max) {
                max = score;
            }
            System.out.printf("[%d,%d] - [%d,%d] => ", anchor, end, values[anchor], values[end]);
            if(isLeftSmallerThanIndexDifference(values, anchor, end)){
                anchor = end;
            }
            System.out.printf("[%d,%d] - [%d,%d] = Score: %s", anchor, end, values[anchor], values[end], max);
            System.out.println();
        }
        return max;
    }

    private boolean isLeftSmallerThanIndexDifference(int[] values, int anchor, int end) {
        return (values[anchor] - values[end]) < (end - anchor);
    }

    public static void main(String[] args) {
        SightSeeingScore main = new SightSeeingScore();
        // int input[] = new int[] { -1, 1, 8, 5, 2, 6 };
        int input[] = new int[] { 8, 1, 5, 2, 6 };
        Assert.assertEquals(11, main.quadraticBruteForceWay(input));
        System.out.println();
        Assert.assertEquals(11, main.linearWay(input));
        // Assert.assertEquals(main.quadraticBruteForceWay(input), main.linearWay(input));
    }
}