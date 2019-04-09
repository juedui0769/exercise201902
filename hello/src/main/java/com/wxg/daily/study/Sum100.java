package com.wxg.daily.study;

/**
 * create at 2019年04月09日19:58:28，
 * 高斯的1~100之和
 * <p>
 * sum : 5050
 * </p>
 * <p>
 * 我口算时总是算出 1~49, 49 * 100 + 50 = 4950
 * </p>
 * <p>
 * 我少加了100，实际是 1~49, 50, 51~99, 100，
 * </p><p>
 * 49*100 + 50 + 100 = 50*100 + 50 = 5050
 * </p>
 */
public class Sum100 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <=100; i++) {
            sum += i;
        }
        System.out.println("sum : " + sum);
    }
}
