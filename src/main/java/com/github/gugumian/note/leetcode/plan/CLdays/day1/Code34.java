package com.github.gugumian.note.leetcode.plan.CLdays.day1;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class Code34 {
    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) >>> 1;
        while(end - start > 1) {
            mid = (start + end) >>> 1;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                break;
            }
            log.info("in while --- start:{}|mid:{}|end:{}", start, mid, end);
        }
        log.info("nums:{}", nums);
        log.info("start:{}|mid:{}|end:{}", start, mid, end);
        if ((end - start) < 2){
            if (end > -1 && (nums[end] == target || nums[start] == target)) {
                start = nums[start] == target ? start : end;
                end = nums[end] == target ? end : start;
            } else {
                start = -1;
                end = -1;
            }
        } else {
            start = binarySearchLeft(nums, target, start, mid);
            end = binarySearchRight(nums, target, mid, end);
        }
        return new int[] {start, end};
    }

    public int binarySearchLeft(int[] nums, int target, int start, int end) {
        log.info("enter left");
        while(end - start > 1) {
            int mid = (start + end) >>> 1;
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
            log.info("left---start:{}|mid:{}|end:{}", start, mid, end);
        }
        return nums[start] == target ? start : end;
    }

    public int binarySearchRight(int[] nums, int target, int start, int end) {
        log.info("enter right");
        while(end - start > 1) {
            int mid = (start + end) >>> 1;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
            log.info("right---start:{}|mid:{}|end:{}", start, mid, end);
        }
        return nums[end] == target ? end : start;
    }

    public static void main(String[] args) {
        Code34 solution = new Code34();
        int[] nums = new int[] {1, 4};
        int target = 4;
        log.info(Arrays.toString(solution.searchRange(nums, target)));
    }
}

/*
分段二分查找，注意边界条件的控制
 */
