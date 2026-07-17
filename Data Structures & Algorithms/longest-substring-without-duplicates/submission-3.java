class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int left_ptr = 0;
        int max_len = map.size();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                while (s.charAt(left_ptr) != s.charAt(i)) {
                    map.remove(s.charAt(left_ptr));
                    left_ptr++;
                }
                if (left_ptr != i) {
                    map.remove(s.charAt(left_ptr));
                    left_ptr++;
                }
                map.put(s.charAt(i), i);
            } else {
                map.put(s.charAt(i), i);
                if (map.size() > max_len) {
                    max_len = map.size();
                }
            }
        }
        return max_len;
    }
}

/*
* use a hashset to track duplicates and sliding window to update set

{z}, substr_len = 1
v
zxyzxyz
* dupe = true

{z, x}, substr_len = 2
vv
zxyzxyz
* dupe = false

{z, x, y}, substr_len = 3
v v
zxyzxyz
* dupe = false

{z, x, y}, substr_len = 3
v  v
zxyzxyz
* dupe = true
* shift_window():
    {x, y, z}, substr_len = 3
    v v
    zxyzxyz


* dupe = true
* shift window

{c, a, d}
v v
cadaxfl

v  v
cadaxfl

shift():
    {d}
      vv
    cadaxfl

{d, a}
  vv
cadaxfl

...
{d, a, x, f, l}
  vv
cadaxfl


------------------------
use map instead
{c:0 , a: 1, d: 2}
v v
cadaxfl

{c:0 , a: 1, d: 2}
v  v
cadaxfl

shift():
    {d: 2, a: 3}
      vv
    cadaxfl

{d: 2, a: 3}
  vv
cadaxfl

...
{d: 2, a: 3, x: 4, f: 5, l: 6}
  v   v
cadaxfl
----------------------------
{d: 0, v: 1}
vv
dvdf

{d: 0, v: 1}
v v
dvdf

*/