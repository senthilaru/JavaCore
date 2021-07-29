package com.spsa.algo.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;

public class SuperReducedString {
    public String superReducedString(String s) {
        List<Character> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.get(stack.size() - 1) == s.charAt(i)) {
                stack.remove(stack.size() - 1);
            } else {
                stack.add(s.charAt(i));
            }
        }
        String result = stack.stream().map(String::valueOf).collect(Collectors.joining());
        return result.isBlank() ? "Empty String" : result;

    }

    public static void main(String[] args) {
        SuperReducedString main = new SuperReducedString();
        Assert.assertEquals("abd", main.superReducedString("aaabccddd"));
    }
}
