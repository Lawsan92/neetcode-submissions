class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Number, Boolean> numberMap = new HashMap<>();
        for (Number num: nums) {
            if (numberMap.containsKey(num)) {
                return true;
            }
            numberMap.put(num, true);
        }
        return false;
    }
}