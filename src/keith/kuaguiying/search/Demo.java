package com.keith.search;

/**
 * TODO 类描述
 *
 * @author yaomianxian
 * @date 2024/04/9 0009 13:40
 */
public class Demo {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,5,5,7};
        int target = 4;
//        int i = searchLeftBound(nums, target);
//        int i = search(nums, target);
        int i = Search20240718.search(nums, target);
        System.out.println(i);
    }
}
