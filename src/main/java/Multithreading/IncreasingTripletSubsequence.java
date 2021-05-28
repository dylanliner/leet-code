package Multithreading;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {

        System.out.println(increasingTriplet(new int[]{8, 7, 6, 5, 0, 4, 6}));
        System.out.println(increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));

    }

    public static boolean increasingTriplet(int[] nums) {


        int lowestNumber = Integer.MAX_VALUE;
        int middleNumber = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= lowestNumber) {
                lowestNumber = nums[i];
            } else if (nums[i] <= middleNumber) {
                middleNumber = nums[i];
            } else {
                return true;
            }
        }
        return false;

    }

    private static boolean checkIfLargerRight(int[] nums, int i) {
        for (int j = i; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkIfSmallerLeft(int[] nums, int i) {
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                return true;
            }
        }
        return false;
    }

}
