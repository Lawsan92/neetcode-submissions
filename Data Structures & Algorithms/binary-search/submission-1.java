class Solution {
    public int search(int[] nums, int target) {
        int s_ptr = 0;
        int e_ptr = nums.length - 1;
        int m_ptr = nums.length / 2;
        
        while (s_ptr <= e_ptr) {
            if (nums[m_ptr] == target) {
                return m_ptr;
            } else if (nums[m_ptr] > target) {
                e_ptr = m_ptr - 1;
                m_ptr = (s_ptr + e_ptr) / 2;
            } else {
                s_ptr = m_ptr + 1;
                m_ptr = (s_ptr + e_ptr) / 2;
            }
        }
        return -1;
    }
}

/*
               v
nums = [-1,0,2,4,6,8], target = 4, ptr = 3

----------------------------------
         s     m   e
         v     v   v
nums = [-1,0,2,4,6,8], target = 3, s = 0, m = 3, s = 5

         s m e
         v v v
nums = [-1,0,2,4,6,8], target = 3, s = 0, m = 1, s = 2
          
             s
             m
             e
             v 
nums = [-1,0,2,4,6,8], target = 3, s = 2, m = 2, s = 2

----------------------------------
  s         m                    e
  v         v                    v
[-1,0,2,4,6,8, 11, 12, 44, 100, 175], target= 4, s = 0, m = 5, e = 10

  s   e   m                    
  v   v   v                    
[-1,0,2,4,6,8, 11, 12, 44, 100, 175], target= 4, s = 0, m = 2, s = 4

  s   e   m                    
  v   v   v                    
[-1,0,2,4,6,8, 11, 12, 44, 100, 175], target= 4, s = 0, m = 2, s = 4


*/
