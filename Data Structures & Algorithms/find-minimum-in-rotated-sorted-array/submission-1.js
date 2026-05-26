class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    findMin(nums) {

        for (let i = 0; i < nums.length; i++) {
            let lowestFlag = nums[0];
            if (nums[i] < lowestFlag) {return nums[i]} ;
        }
        return nums[0];
    }
}

/**
 - Input: nums = [4,5,0,1,2,3]
 - Output: 0
 - original [0, 1, 2, 3, 4, 5]; rotated  4 times
 - 0 is at nums[2] 
 // starting from nums[0], if the next number is larger, keep moving up, otherwise end the iteration

 - Input: nums = [3,4,5,6,1,2]
 - Output: 1
 - original [1, 2, 3, 4, 5, 6]; rotated  2 times
 - 1 is at nums[4] = length - number of rotations

// set value flag
// iterate over arrary
  // 

alogirthm: 

 */