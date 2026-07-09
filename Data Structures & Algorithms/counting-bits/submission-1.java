class Solution {
    public int[] countBits(int n) {
        int[] binArr = new int[ n + 1];
        int count = 0;
        for (int i = 0; i < binArr.length; i ++) {
            int j = n - i;
            while (j > 0) {
                if (j % 2 == 1)  count ++;
                j /= 2;
            }
            binArr[n - i] = count;
            count = 0;
        }
        return binArr;
    }
}
