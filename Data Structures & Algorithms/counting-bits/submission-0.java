class Solution {
    public int[] countBits(int n) {
        ArrayList<Integer> binArr = new ArrayList<Integer>();
        int count = 0;
        while (n > 0) {
            int i = n;
            while (i > 0) {
                if (i % 2 == 1)  count ++;
                i = i / 2;
            }
            binArr.add(0, count);
            count = 0;
            n--;
        }
        binArr.add(0, 0);
        
        return binArr.stream().mapToInt(Integer::intValue).toArray();
    }
}
