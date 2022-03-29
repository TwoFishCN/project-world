package com.project.world.algorithm;

public class Is2Sqrt {

    public static void main(String[] args) {
        Is2Sqrt is2Sqrt = new Is2Sqrt();
//        for (int i = 0; i < 2000; i++) {
//            if (is2Sqrt.isPowerOfTwo(i)) {
//                System.out.println(i);
//            }
//        }
        System.out.println(Math.pow(2, -3));
        System.out.println(is2Sqrt.isPowerOfTwo(-8));
    }

    public boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }
        return findIndex(0, 32, n);
    }

    public boolean findIndex(int start, int end, int n) {
        int index = (start + end) / 2;
        long value = (long) Math.pow(2, index);
        int nAbs = Math.abs(n);
        if (value == nAbs) {
            return true;
        } else if (value > nAbs) {
            end = index - 1;
        } else if (value < nAbs) {
            start = index + 1;
        }

        if (start == end) {
            return (long) Math.pow(2, start) == n;
        } else if (start > end) {
            return false;
        } else {
            return findIndex(start, end, n);
        }
    }
}
